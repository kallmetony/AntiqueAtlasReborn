package hunternif.mc.impl.atlas.structure;

import hunternif.mc.impl.atlas.core.TileIdMap;
import net.minecraft.structure.StructurePiece;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;

import java.util.Collection;
import java.util.Collections;

public class Overworld {

    public static void registerPieces() {
        StructureHandler.registerTile(StructurePieceType.RUINED_PORTAL, 10, TileIdMap.RUINED_PORTAL, Overworld::aboveGround);
        StructureHandler.registerTile(StructurePieceType.SHIPWRECK, 10, TileIdMap.SHIPWRECK, Overworld::always);
    }

    private static Collection<ChunkPos> aboveGround(World world, @SuppressWarnings("unused") StructurePoolElement structurePoolElement, BlockBox blockBox, StructurePiece piece) {
        BlockPos center = new BlockPos(blockBox.getCenter());
        if (world.getSeaLevel() - 4 <= center.getY()) {
            return Collections.singleton(new ChunkPos(center));
        }

        return Collections.emptyList();
    }

    private static Collection<ChunkPos> always(World world, @SuppressWarnings("unused") StructurePoolElement structurePoolElement, BlockBox blockBox, StructurePiece piece) {
        BlockPos center = new BlockPos(blockBox.getCenter());
        return Collections.singleton(new ChunkPos(center));
    }
}

package world

import (
	"github.com/gen2brain/raylib-go/raylib"
)

var DIRT_BLOCK = Block{
	Name:    "Dirt",
	Texture: rl.Color{139, 69, 19, 100},
}

var STONE_BLOCK = Block{
	Name:    "Stone",
	Texture: rl.Color{192, 192, 192, 90},
}

var WOOD_BLOCK = Block{
	Name:    "Wood",
	Texture: rl.Color{128, 0, 0, 100},
}

var AIR_BLOCK = Block{
	Name:    "Air",
	Texture: rl.Color{0, 0, 0, 0},
}

var mined_item = Item{
	Name:    block.Name,
	Texture: &block.Texture,
}

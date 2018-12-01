package world

import (
	"github.com/gen2brain/raylib-go/raylib"
)

//Block struct
type Block struct {
	Name    string
	Texture rl.Color
	// Size rl.Vector2 NOTE: Block size is constant
	// TODO: Type
}

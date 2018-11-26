package world

import (
	"github.com/gen2brain/raylib-go/raylib"
)

type World struct {
	Pos  rl.Vector2
	Size rl.Vector2

	Blocks map[rl.Vector2]Block
}

func (world *World) Start() {
	world.Blocks = make(map[rl.Vector2]Block)

	for i := float32(0); i < world.Size.X; i++ {
		for j := float32(0); j < world.Size.Y; j++ {
			pos := rl.Vector2{float32(i), float32(j)}
			world.Blocks[pos] = Block{Pos: rl.Vector2{i, j}, Size: rl.Vector2{float32(20), float32(20)}}
		}
	}
}

func (world *World) Tick(dt float32) {

}

func Vec2Mult(v1, v2 rl.Vector2) rl.Vector2 {
	x := v1.X * v2.X
	y := v1.Y * v2.Y
	return rl.Vector2{x, y}
}

func (world *World) Render() {
	for pos, block := range world.Blocks {
		rl.DrawRectangleV(Vec2Mult(pos, block.Size), block.Size, rl.Black)
	}
}

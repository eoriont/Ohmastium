package world

import (
	u "../utilities"
	. "./blocks"
	s "./structures"
	"github.com/gen2brain/raylib-go/raylib"
)

//World Struct
type World struct {
	Pos  rl.Vector2
	Size rl.Vector2

	Blocks map[rl.Vector2]Block
}

var TestFusor s.Fusor

//Start the world
func (world *World) Start() {
	TestFusor.Start()
	world.Blocks = make(map[rl.Vector2]Block)

	for i := float32(0); i < world.Size.X; i++ {
		for j := float32(0); j < world.Size.Y; j++ {
			pos := rl.Vector2{float32(i), float32(j)}
			world.Blocks[pos] = Block{Size: rl.Vector2{float32(20), float32(20)}}
		}
	}
}

//Tick the world
func (world *World) Tick(dt float32) {
	TestFusor.Tick()
}

//Render the world
func (world *World) Render() {
	for pos, block := range world.Blocks {
		rl.DrawRectangleV(u.Vec2Mult(pos, block.Size), block.Size, rl.Black)
	}
	TestFusor.Render()
}

//GetWorld gets the world from file (hardcoded for now)
func GetWorld() World {
	return World{
		Pos:    rl.Vector2{X: 0, Y: 0},
		Size:   rl.Vector2{X: 10, Y: 105},
		Blocks: nil,
	}
}

package world

import (
	. "./blocks"
	s "./structures"
	"github.com/gen2brain/raylib-go/raylib"
	rm "github.com/gen2brain/raylib-go/raymath"
)

//World Struct
type World struct {
	Pos        rl.Vector2
	Size       rl.Vector2
	Structures []s.Structure
	Blocks     map[rl.Vector2]Block
}

//Start the world
func (world *World) Start() {
	world.LoadWorld()
	world.LoadStructures()
}

//Tick the world
func (world *World) Tick(dt float32) {

}

//Render the world
func (world *World) Render() {
	//BLOCKS
	for pos, _ := range world.Blocks {
		loc := rm.Vector2Add(world.Pos, pos)
		rl.DrawRectangleV(loc, rm.Vector2Add(loc, rl.Vector2{20, 20}), world.Blocks[pos].Texture)
	}
	//STRUCTURES
	for _, s := range world.Structures {
		s.Render()
	}
}

//LoadWorld , (Generated for now, file system soon)
func (world *World) LoadWorld() {
	world.Pos = rl.Vector2{X: 20, Y: 20}
	world.Size = rl.Vector2{X: 100, Y: 100}
	world.Blocks = make(map[rl.Vector2]Block)

	for i := float32(0); i < world.Size.X; i++ {
		for j := float32(0); j < world.Size.Y; j++ {
			pos := rl.Vector2{X: float32(i), Y: float32(j)}
			world.Blocks[pos] = Block{"FakeDirt", rl.Color{139, 69, 19, 100}}
		}
	}
}

//LoadStructures , (Generated for now, file system soon)
func (world *World) LoadStructures() {
	for i := 0; i < 3; i++ {
		fusor := s.Fusor{}
		fusor = s.NewFusor(rl.Vector2{X: float32(i * 30), Y: 0})
		world.Structures = append(world.Structures, fusor)

		bench := s.WorkBench{}
		bench = s.NewBench(rl.Vector2{X: float32(i * 30), Y: 30})
		world.Structures = append(world.Structures, bench)
	}
}

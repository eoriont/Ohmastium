package world

import (
	"github.com/gen2brain/raylib-go/raylib"
)

// THIS IS AN EXAMPLE OF HOW TO TEMPLATE A STRUCTURE

//WorkBench structure
type WorkBench struct {
	Pos     rl.Vector2
	Texture rl.Color
	Size    rl.Vector2
	Level   int8
}

//Start bench frome file (Hard coded for now)
func (b WorkBench) Start() {

}

//Tick for bench operations
func (b WorkBench) Tick() {

}

//Render the bench
func (b WorkBench) Render() {
	rl.DrawRectangleV(b.Pos, b.Size, b.Texture)
}

func NewBench(pos rl.Vector2) WorkBench {
	var b WorkBench
	b.Pos = pos
	b.Texture = rl.Color{R: 0, G: 50, B: 50, A: 255}
	b.Size = rl.Vector2{X: 20, Y: 20}
	b.Level = 1
	return b
}

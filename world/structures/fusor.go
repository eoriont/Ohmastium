package world

import (
	"github.com/gen2brain/raylib-go/raylib"
)

//Fusor structure
type Fusor struct {
	Pos     rl.Vector2
	Texture rl.Color
	Size    rl.Vector2
	Level   int8
}

//Start fusor frome file (Hard coded for now)
func (f Fusor) Start() {

}

//Tick for fusor operations
func (f Fusor) Tick() {

}

//Render the fusor
func (f Fusor) Render() {
	rl.DrawRectangleV(f.Pos, f.Size, f.Texture)
}

func NewFusor(pos rl.Vector2) Fusor {
	var f Fusor
	f.Pos = pos
	f.Texture = rl.Color{R: 0, G: 150, B: 150, A: 255}
	f.Size = rl.Vector2{X: 20, Y: 20}
	f.Level = 1
	return f
}

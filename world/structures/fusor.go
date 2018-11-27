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
func (f *Fusor) Start() {
	f.Pos = rl.Vector2{X: 10, Y: 10}
	f.Texture = rl.Color{R: 0, G: 150, B: 150, A: 255}
	f.Size = rl.Vector2{X: 20, Y: 20}
	f.Level = 1
}

//Tick for fusor operations
func (f *Fusor) Tick() {

}

//Render the fusor
func (f *Fusor) Render() {
	rl.DrawRectangleV(f.Pos, f.Size, f.Texture)
}

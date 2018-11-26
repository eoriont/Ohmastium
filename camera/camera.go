package camera

import (
	"github.com/gen2brain/raylib-go/raylib"
)

var Camera rl.Camera2D

func CreateCamera() {
	Camera = rl.Camera2D{Offset: rl.Vector2{0, 0}, Target: rl.Vector2{500, 500}, Rotation: 0, Zoom: 1}
}

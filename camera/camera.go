package camera

import (
	"github.com/gen2brain/raylib-go/raylib"
)

//Public Camera
var (
	MainCamera *rl.Camera2D
	GUICamera  *rl.Camera2D
)

func InitCameras() {
	initMainCamera()
	initGUICamera()
}

func initMainCamera() {
	MainCamera = &rl.Camera2D{
		Offset:   rl.Vector2{X: 0, Y: 0},
		Target:   rl.Vector2{X: 0, Y: 0},
		Rotation: 0,
		Zoom:     1,
	}
}

func initGUICamera() {
	GUICamera = &rl.Camera2D{
		Offset:   rl.Vector2{X: 0, Y: 0},
		Target:   rl.Vector2{X: 0, Y: 0},
		Rotation: 0,
		Zoom:     1,
	}
}

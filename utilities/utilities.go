package utilities

import (
	"time"

	"github.com/gen2brain/raylib-go/raylib"
)

//WinSize is a public variable to get window size
var WinSize rl.Vector2

//SetWindowSize sets public WinSize Variable
func SetWindowSize(x, y float32) {
	WinSize = rl.Vector2{X: x, Y: y}
}

//Vec2Mult multiply corresponding values, return product vector
func Vec2Mult(v1, v2 rl.Vector2) rl.Vector2 {
	x := v1.X * v2.X
	y := v1.Y * v2.Y
	return rl.Vector2{X: x, Y: y}
}

//MakeTimestamp of the current millisecond
func MakeTimestamp() int64 {
	return time.Now().UnixNano() / int64(time.Millisecond)
}

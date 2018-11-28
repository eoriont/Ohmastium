package devcookie

import (
	"fmt"

	u "../utilities"
	"github.com/gen2brain/raylib-go/raylib"
)

//DisplayOrigin , read the function name
func DisplayOrigin() {
	rl.DrawText("0,0", int32(10), int32(-15), int32(15), rl.LightGray)
	rl.DrawLineEx(rl.Vector2{-25, 0}, rl.Vector2{25, 0}, 2, rl.LightGray)
	rl.DrawLineEx(rl.Vector2{0, 25}, rl.Vector2{0, -25}, 2, rl.LightGray)
}

func DisplayFPS() {
	rl.DrawText(fmt.Sprintf("FPS: %.1f", rl.GetFPS()), int32(u.WinSize.X-120), 20, 20, rl.Black)
}

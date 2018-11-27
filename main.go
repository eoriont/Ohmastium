package main

import (
	c "./camera"
	"./player"
	u "./utilities"
	"./world"
	"github.com/gen2brain/raylib-go/raylib"
)

func main() {
	u.SetWindowSize(1000, 1000) //See utilities
	rl.InitWindow(int32(u.WinSize.X), int32(u.WinSize.Y), "Ohmastium")

	fps := 60
	rl.SetTargetFPS(int32(fps))
	lastTick := u.MakeTimestamp()

	start()
	for !rl.WindowShouldClose() {
		nowTime := u.MakeTimestamp()

		dt := nowTime - lastTick
		if dt >= int64(1000/fps) {
			tick(float32(dt))
			render()
			lastTick = nowTime
		}
	}
}

var (
	p player.Player
	w world.World
)

func start() {
	//Setting Variables
	p = player.GetPlayer()
	w = world.GetWorld()
	c.InitCamera()
	w.Start()
	p.Start()
}

func tick(dt float32) {
	p.Tick(dt)
	w.Tick(dt)
}

func render() {
	rl.BeginDrawing()
	rl.BeginMode2D(*c.MainCamera)
	defer rl.EndMode2D()
	defer rl.EndDrawing()
	rl.ClearBackground(rl.RayWhite)
	w.Render()
	p.Render()
}

package main

import (
	c "./camera"
	"./devcookie"
	"./player"
	u "./utilities"
	"./world"
	"github.com/gen2brain/raylib-go/raylib"
)

func main() {
	u.SetWindowSize(1000, 1000)
	rl.InitWindow(int32(u.WinSize.X), int32(u.WinSize.Y), "Ohmastium")

	fps := 60
	ticks := 100
	rl.SetTargetFPS(int32(fps))
	lastTick := u.MakeTimestamp()

	start() //Load assets, Game data, and initialize variables
	for !rl.WindowShouldClose() {
		nowTime := u.MakeTimestamp()

		dt := nowTime - lastTick
		if dt >= int64(1000/ticks) {
			tick(float32(dt))
			lastTick = nowTime
		}
		render()
	}
}

var (
	p player.Player
	w world.World
)

func start() {
	//Setting Variables
	p = player.GetPlayer()
	c.InitCameras()
	w.Start()
	p.Start()
}

func tick(dt float32) {
	p.Tick(dt)
	w.Tick(dt)
}

func render() {
	rl.BeginDrawing()
	defer rl.EndDrawing()

	//Main Camera
	rl.BeginMode2D(*c.MainCamera)
	rl.ClearBackground(rl.RayWhite)
	w.Render()
	p.Render()
	devcookie.DisplayOrigin()
	rl.EndMode2D()

	//GUI
	rl.BeginMode2D(*c.GUICamera)
	devcookie.DisplayFPS()
	rl.EndMode2D()
}

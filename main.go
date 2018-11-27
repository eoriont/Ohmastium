package main

import (
	c "./camera"
	"./player"
	u "./utilities"
	"./world"
	"github.com/gen2brain/raylib-go/raylib"
)

func main() {
	u.SetWindowSize(800, 450) //See utilities
	rl.InitWindow(int32(u.WinSize.X), int32(u.WinSize.Y), "Ohmastium")
	rl.SetTargetFPS(240)

	start()
	for !rl.WindowShouldClose() {
		tick(1)
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

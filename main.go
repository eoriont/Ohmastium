package main

import (
	"./player"
	"./world"
	"github.com/gen2brain/raylib-go/raylib"
)

var (
	p       player.Player
	w       world.World
	camera  rl.Camera2D
	winSize = rl.Vector2{800, 450}
)

func main() {
	rl.InitWindow(int32(winSize.X), int32(winSize.Y), "Ohmastium")
	rl.SetTargetFPS(60)

	start()
	for !rl.WindowShouldClose() {
		tick(1)
		render()
	}
}

func start() {
	p = player.Player{Pos: rl.Vector2{0, 0}, Size: rl.Vector2{100, 150}, Speed: 5}
	w = world.World{Pos: rl.Vector2{0, 0}, Size: rl.Vector2{10, 10}, Blocks: nil}
	camera = rl.Camera2D{Offset: rl.Vector2{0, 0}, Target: rl.Vector2{500, 500}, Rotation: 0, Zoom: 1}
	w.Start()
	p.Start(&camera, winSize)
}

func tick(dt float32) {
	p.Tick(dt)
	w.Tick(dt)
	camera.Target = p.Pos
}
func render() {
	rl.BeginDrawing()
	rl.BeginMode2D(camera)
	rl.ClearBackground(rl.RayWhite)
	w.Render()
	p.Render()
	rl.EndMode2D()
	rl.EndDrawing()
}

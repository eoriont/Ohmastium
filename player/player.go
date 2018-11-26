package player

import (
	"github.com/gen2brain/raylib-go/raylib"
)

type Player struct {
	Pos    rl.Vector2
	Size   rl.Vector2
	Speed  float32
	camera *rl.Camera2D
}

func centerPlayerToCamera(player *Player, winSize rl.Vector2) {
	player.camera.Offset.X = (winSize.X-player.Size.X)/2 - player.Pos.X
	player.camera.Offset.Y = (winSize.Y-player.Size.Y)/2 - player.Pos.Y
}

func (player *Player) Start(camera *rl.Camera2D, winSize rl.Vector2) {
	player.camera = camera
	centerPlayerToCamera(player, winSize)
}

func (player *Player) Tick(dt float32) {
	if rl.IsKeyDown(rl.KeyW) {
		player.Pos.Y -= player.Speed
		player.camera.Offset.Y += player.Speed
	}
	if rl.IsKeyDown(rl.KeyS) {
		player.Pos.Y += player.Speed
		player.camera.Offset.Y -= player.Speed
	}
	if rl.IsKeyDown(rl.KeyA) {
		player.Pos.X -= player.Speed
		player.camera.Offset.X += player.Speed
	}
	if rl.IsKeyDown(rl.KeyD) {
		player.Pos.X += player.Speed
		player.camera.Offset.X -= player.Speed
	}
	player.camera.Target = player.Pos //Set camera to track player
}

func (player *Player) Render() {
	rl.DrawRectangleV(player.Pos, player.Size, rl.Red)
}

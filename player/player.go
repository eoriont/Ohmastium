package player

import (
	c "../camera"
	u "../utilities"
	"github.com/gen2brain/raylib-go/raylib"
)

//Player struct
type Player struct {
	Pos   rl.Vector2
	Size  rl.Vector2
	Speed int
}

//Centers camera to target
func centerCameraToPlayer(player *Player) {
	c.MainCamera.Offset.X = (u.WinSize.X-player.Size.X)/2 - player.Pos.X
	c.MainCamera.Offset.Y = (u.WinSize.Y-player.Size.Y)/2 - player.Pos.Y
}

//Start player, set camera to target
func (player *Player) Start() {
	centerCameraToPlayer(player)
}

//Tick for player, check movements and updated player position and camera
func (player *Player) Tick(dt float32) {
	if rl.IsKeyDown(rl.KeyW) {
		player.Pos.Y -= float32(player.Speed) * dt
	}
	if rl.IsKeyDown(rl.KeyS) {
		player.Pos.Y += float32(player.Speed) * dt
	}
	if rl.IsKeyDown(rl.KeyA) {
		player.Pos.X -= float32(player.Speed) * dt
	}
	if rl.IsKeyDown(rl.KeyD) {
		player.Pos.X += float32(player.Speed) * dt
	}
	centerCameraToPlayer(player)
	c.MainCamera.Target = player.Pos
}

//Render the player
func (player *Player) Render() {
	rl.DrawRectangleV(player.Pos, player.Size, rl.Red)
}

//GetPlayer gets the player from file (hardcoded for now)
func GetPlayer() Player {
	return Player{
		Pos:   rl.Vector2{X: 110, Y: 110},
		Size:  rl.Vector2{X: 90, Y: 90},
		Speed: 2,
	}
}

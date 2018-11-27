package world

type Structure interface {
	Start()
	Tick()
	Render()
}

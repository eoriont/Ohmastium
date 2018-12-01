package main

import (
	"fmt"
	"reflect"
)

type Block struct {
	name    string
	texture string
	item    *BlockItem
}

type BlockItem struct {
	name    string
	texture string
	block   *Block
}

type Element struct {
	name    string
	texture string
	etrons  int
	atrons  int
}

type Bucket struct {
	name     string
	texture  string
	isFilled bool
}

type Armour struct {
	name     string
	texture  string
	kind     string
	strength string
}

//Methods that initialize Element as an item type
func (e Element) ItemName() string {
	return e.name
}
func (e Element) ItemTexture() string {
	return e.texture
}

//Methods that initialize BlockItem as an item type
func (i BlockItem) ItemName() string {
	return i.name
}
func (i BlockItem) ItemTexture() string {
	return i.texture
}

//Custom Element Methods
func (e Element) GetParticles() (int, int) {
	return e.etrons, e.atrons
}

//Item method schematic (NOTE: if struct does not has these methods then it is not an item)
type Item interface {
	ItemName() string
	ItemTexture() string
}

func isElement(i Item) bool {
	return reflect.TypeOf(i) == reflect.TypeOf(Element{})
}

type StorageSlot struct {
	item   Item
	amount int
}

func main() {
	var (
		DIRT_ITEM = BlockItem{
			name:    "Dirt",
			texture: "Brown",
		}
		DIRT_BLOCK = Block{
			name:    "Dirt",
			texture: "Brown",
		}
	)
	BindPlacable(&DIRT_ITEM, &DIRT_BLOCK)
	var (
		OHMASTIUM = Element{
			name:    "Ohmastium",
			texture: "Bluish Grey",
			etrons:  1,
			atrons:  1,
		}
	)
	fmt.Println(isElement(DIRT_ITEM)) //false
	fmt.Println(isElement(OHMASTIUM)) //true

	testStack := StorageSlot{OHMASTIUM, 60}
	fmt.Println(testStack)
}

func BindPlacable(i *BlockItem, b *Block) {
	i.block = b
	b.item = i
}

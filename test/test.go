package main

import (
	"fmt"
	"reflect"
)

type Block struct {
	Name    string
	Texture string
	Item    *BlockItem
}

type BlockItem struct {
	Name    string
	Texture string
	Block   *Block
}

type Element struct {
	Name    string
	Texture string
	Etrons  int
	Atrons  int
}

type Bucket struct {
	Name     string
	Texture  string
	Kind     string
	IsFilled bool
}

func (b Bucket) IsBucketFilled() bool {
	return b.IsFilled
}
func (b Bucket) BucketType() string {
	return b.Kind
}

type Armour struct {
	Name     string
	Texture  string
	kind     string
	Strength string
}

//Custom Element Methods
func (e Element) GetParticles() (int, int) {
	return e.Etrons, e.Atrons
}

//Item method schematic (NOTE: if struct does not has these methods then it is not an item)
type Item interface{}

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
			Name:    "Dirt",
			Texture: "Brown",
		}
		DIRT_BLOCK = Block{
			Name:    "Dirt",
			Texture: "Brown",
		}
	)
	BindPlacable(&DIRT_ITEM, &DIRT_BLOCK)
	var (
		OHMASTIUM = Element{
			Name:    "Ohmastium",
			Texture: "Bluish Grey",
			Etrons:  1,
			Atrons:  1,
		}
	)
	fmt.Println(isElement(DIRT_ITEM)) //false
	fmt.Println(isElement(OHMASTIUM)) //true

	var (
		WATER_BUCKET = Bucket{
			Name:    "Water Bucket",
			Texture: "Grey",
			Kind:    "water",
		}
	)
	myBucket := StorageSlot{WATER_BUCKET, 1}
	fmt.Println(isElement(myBucket.item))

	testStack := StorageSlot{OHMASTIUM, 60}
	fmt.Println(testStack)
}

func BindPlacable(i *BlockItem, b *Block) {
	i.Block = b
	b.Item = i
}

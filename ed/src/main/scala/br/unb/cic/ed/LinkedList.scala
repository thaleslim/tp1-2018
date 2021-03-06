package br.unb.cic.ed


case class NodeList(val value: Integer, var next: NodeList)

class LinkedList extends List {

  private var _size: Int = 0 
  private var head: NodeList = null

  def size(): Int = _size

  private def nodeAtPosition(pos: Int): NodeList = {
    var it = head
    for(i <- 0 until pos) {
      it = it.next
    }
    return it
  }

  def find(value: Int): Option[Int] = {
    if(size == 0) { return None }
    var it = head
    var idx = 0
    while(it != null) {
      if(it.value == value) {
        return Some(idx); 
      }
      it = it.next
      idx += 1
    }
    return None
  }

  def elementAt(pos: Int): Option[Int] = {
    if(pos < 0 || pos > _size) {
      return None
    }
    val node = nodeAtPosition(pos)
    return Some(node.value)
  }

  def insert(pos: Int, value: Int){
    if(pos >=0 && pos <= _size) {
      if(pos == 0) {
        head = NodeList(value, head) 
      }
      else {
        val node = nodeAtPosition(pos-1)
        node.next = NodeList(value, node.next)
      }
      _size += 1
    }
    else {
      throw br.unb.cic.ed.InvalidArgument()
    }
  }

  def remove(pos: Int): Unit = {
    if(pos < 0 || pos >= size) {
      throw br.unb.cic.ed.InvalidArgument()
    }
    if(pos == 0) {
      head = head.next
    }
    else {
      val node = nodeAtPosition(pos-1)
      node.next = node.next.next
    }
    _size -= 1
  }
}

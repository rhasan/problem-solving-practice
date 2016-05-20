using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fundamentals
{
    class LinkedStack<Item>:IStack<Item>
    {
        private Node first = null;
        int N;
        public LinkedStack()
        {
            first = null;
            N = 0;
        }
        private class Node
        {
            public Item item;
            public Node next;
        }

        public Item pop()
        {
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        }

        public void push(Item item)
        {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            N++;
        }

        public bool isEmpty()
        {
            return size() == 0;
        }

        public int size()
        {
            return N;
        }
    }
}

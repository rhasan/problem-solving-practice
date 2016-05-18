using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fundamentals
{
    class Stack<Item>
    {
        Item[] m_items;
        int N;
        public Stack()
        {
            m_items = new Item[1];
            N = 0;
        }

        public void push(Item item) 
        {
            if (N == m_items.Length)
            {
                resize(2 * m_items.Length);
            }
            m_items[N++] = item;
        }

        private void resize(int capacity)
        {
            Item[] copy = new Item[capacity];
            for (int i = 0; i < N; i++)
            {
                copy[i] = m_items[i];
            }
            m_items = copy;
        }


        public Item pop()
        {
            Item item = m_items[--N];
            m_items[N] = default(Item);
            if (N > 0 && N == m_items.Length / 4) 
            { 
                resize(m_items.Length / 4); 
            }
            return item;
        }
    }
}

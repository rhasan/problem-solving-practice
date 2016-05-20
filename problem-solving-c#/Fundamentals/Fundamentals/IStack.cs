using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fundamentals
{
    interface IStack<Item>
    {
        void push(Item item);
        Item pop();
        bool isEmpty();
        int size();
    }
}

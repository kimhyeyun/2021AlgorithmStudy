#include <iostream>
using namespace std;

struct Node
{
    int data;
    Node *next;

    Node(int data)
    {
        this->data = data;
        this->next = NULL;
    }
};

class Queue
{
public:
    Node *start;
    Node *end;
    int sz;

    Queue()
    {
        start = NULL;
        end = NULL;
        sz = 0;
    }

    void push(int data)
    {
        if (start == NULL)
        {
            start = new Node(data);
            end = start;
            sz++;
        }
        else
        {
            Node *nNode = new Node(data);
            end->next = nNode;
            end = nNode;
            sz++;
        }
    }

    int pop()
    {
        if (start == NULL)
        {
            return -1;
        }
        else
        {
            int tmp = start->data;
            start = start->next;
            sz--;
            return tmp;
        }
    }

    int size()
    {
        return sz;
    }

    bool empty()
    {
        return (sz==0);
    }

    int front()
    {
        if (start == NULL)
            return -1;

        return start->data;
    }

    int back()
    {
        if (start == NULL)
            return -1;
        return end->data;
    }
};

int main()
{
    Queue *q = new Queue();

    int n;
    cin >> n;

    string str;

    for(int i=0;i<n;i++)
    {
        cin >> str;

        if (str == "push")
        {
            int x;
            cin >> x;
            q->push(x);
        }
        else if (str == "pop")
            cout << q->pop() << "\n";

        else if (str == "size")
            cout << q->size() << "\n";

        else if (str == "empty")
            cout << q->empty() << "\n";

        else if (str == "front")
            cout << q->front() << "\n";

        else if (str == "back")
            cout << q->back() << "\n";
        else 
            i++;
    }
}
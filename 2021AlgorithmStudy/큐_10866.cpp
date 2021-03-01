#include <iostream>
using namespace std;

struct Node
{
    int data;
    Node *prev;
    Node *next;

    Node(int data)
    {
        this->data = data;
        this->prev = NULL;
        this->next = NULL;
    }
};

class Dequeue
{
public:
    Node *head;
    Node *tail;
    int sz;

    Dequeue()
    {
        head = NULL;
        tail = NULL;
        sz = 0;
    }

    void push_front(int x)
    {
        Node *newN = new Node(x);
        if (head == NULL)
        {
            head = newN;
            tail = head;
        }
        else
        {
            head->prev = newN;
            newN->next = head;
            head = newN;
        }

        sz++;
    }

    void push_back(int x)
    {
        Node *newN = new Node(x);
        if (head == NULL)
        {
            head = newN;
            tail = head;
        }
        else
        {
            tail->next = newN;
            newN->prev = tail;
            tail = newN;
        }
        sz++;
    }

    int pop_front()
    {
        if (head == NULL)
        {
            return -1;
        }
        else
        {
            Node *tmp = head;
            int d = tmp->data;
            if (sz > 1)
            {
                head = head->next;
                head->prev = NULL;
            }
            else
            {
                head = tail = NULL;
            }
            sz--;
            delete tmp;
            return d;
        }
    }

    int pop_back()
    {
        if (head == NULL)
            return -1;

        else
        {
            Node *tmp = tail;
            int d = tmp->data;
            if (sz > 1)
            {
                tail = tail->prev;
                tail->next = NULL;
            }
            else
            {
                head = tail = NULL;
            }

            sz--;
            delete tmp;
            return d;
        }
    }

    int size()
    {
        return sz;
    }

    bool empty()
    {
        return (sz == 0);
    }

    int front()
    {
        if (head == NULL)
            return -1;

        return head->data;
    }

    int back()
    {
        if (head == NULL)
            return -1;

        return tail->data;
    }
};

int main()
{
    Dequeue *dq = new Dequeue();

    int n;
    string str;

    cin >> n;

    while (n--)
    {
        cin >> str;

        if (str == "push_front")
        {
            int x;
            cin >> x;
            dq->push_front(x);
        }

        else if (str == "push_back")
        {
            int x;
            cin >> x;
            dq->push_back(x);
        }

        else if (str == "pop_front")
        {
            cout << dq->pop_front() << "\n";
        }
        else if (str == "pop_back")
            cout << dq->pop_back() << "\n";

        else if (str == "size")
            cout << dq->size() << "\n";

        else if (str == "empty")
            cout << dq->empty() << "\n";
        else if (str == "front")
            cout << dq->front() << "\n";
        else if (str == "back")
            cout << dq->back() << "\n";
    }
}
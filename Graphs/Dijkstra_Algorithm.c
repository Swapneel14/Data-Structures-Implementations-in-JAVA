#include<stdio.h>
#include<stdlib.h>
#include<limits.h>
#include<stdbool.h>
#include<time.h>

#define V 10
#define INF INT_MAX
#define MAX_HEAP 100

//Adjacency List:-

typedef struct AdjListNode{
     int dest;
     int weight;

     struct AdjListNode* next;

    } Node;

//Graph:-
typedef struct List{
   Node* head[V];
}Graph;

//Heap Nodes:;-
typedef struct{
    int vertex;
    int distance;
}HeapNode;


//Priority Queue
typedef struct{
    HeapNode array[MAX_HEAP];
    int size;
}pq;

void swap(HeapNode* a, HeapNode* b){
    HeapNode temp = *a;
    *a = *b;
    *b=temp;
}

//push at last then upheap
void push(pq* heap,int vertex,int dist){
    int ind = heap->size++;
    heap->array[ind].vertex = vertex;
    heap->array[ind].distance = dist;

    while(ind!=0&&(heap->array[(ind-1)/2]).distance>heap->array[ind].distance){
        swap(&heap->array[ind],&heap->array[(ind-1)/2]);
        ind = (ind-1)/2;
    }
}

//pop from first then downheap

HeapNode pop(pq* heap){
    if(heap->size==0)return (HeapNode){-1,-1};
    if(heap->size==1) return heap->array[--heap->size];

    HeapNode root = heap->array[0];
    heap->array[0]=heap->array[--heap->size];

    int i=0;

    while(true){
        int left = 2*i + 1;
        int right = 2*i + 2;
        int smallest = i;
        
        if(left<heap->size&&heap->array[left].distance<heap->array[smallest].distance){
            smallest = left;
        }
        if(right<heap->size&&heap->array[right].distance<heap->array[smallest].distance){
            smallest = right;
        }

        if(smallest!=i){
            swap(&heap->array[i],&heap->array[smallest]);
            i = smallest;
        }
        else{
            break;
        }

    }

    return root;

}

void initGraph(Graph* graph){
    for(int i = 0;i<V;i++){
        graph->head[i]=NULL;
    }
}

void addEdgeList(Graph* graph,int src,int dest,int weight){
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->dest=dest;
    newNode->weight=weight;
    newNode->next=graph->head[src];
    graph->head[src]= newNode;
}

void initMatrix(int matrix[V][V]){
    for(int i = 0;i<V;i++){
        for(int j=0;j<V;j++){
            matrix[i][j]=0;
        }
    }
}

void addEdgeMatrix(int matrix[V][V],int src,int dest,int weight){
    matrix[src][dest]= weight;
}

void DijkstraList(Graph* graph,int src){
    int dist[V];
    

    pq heap = {.size=0};

    for(int i = 0;i<V;i++){
        dist[i]=INF;
        

    }

    dist[src]=0;
    push(&heap,src,0);

    while(heap.size>0){
        HeapNode curr = pop(&heap);
        int u = curr.vertex;
        int currentDistance = curr.distance;

        if(currentDistance>dist[u])continue;

        Node* temp = graph->head[u];

        while(temp!=NULL){
            int v = temp->dest;
            int weight = temp->weight;

            if(dist[u]!=INF&&dist[u]+weight<dist[v]){
                dist[v]=dist[u]+weight;
                push(&heap,v,dist[v]);
            }

            temp = temp->next;
        }


    }

}


void DijkstraMatrix(int matrix[V][V],int src){
    int dist[V];
    pq heap = {.size=0};

    for(int i = 0 ;i<V;i++){
        dist[i]=INF;
    }

    dist[src]=0;
    push(&heap,src,0);

    while(heap.size>0){
        HeapNode curr = pop(&heap);
        int u = curr.vertex;
        int currentDistance = curr.distance;

        if(currentDistance>dist[u])continue;

        for (int v = 0; v < V; v++) {
            if (matrix[u][v] > 0) {
                int weight = matrix[u][v];
                
                if (dist[u] != INF && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    push(&heap, v, dist[v]);
                }
            }
        }


        
    }


}



void printList(Graph* graph) {
    printf("\n--- Adjacency List ---\n");
    for (int i = 0; i < V; i++) {
        printf("City %d: ", i);
        Node* temp = graph->head[i];
        
        if (temp == NULL) {
            printf("No outgoing roads");
        }
        
        while (temp != NULL) {
            printf("-> [To City %d, Cost: %d] ", temp->dest, temp->weight);
            temp = temp->next;
        }
        printf("\n");
    }
}

void printMatrix(int matrix[V][V]) {
    printf("\n--- Adjacency Matrix ---\n");
    
    
    printf("     ");
    for (int i = 0; i < V; i++) {
        printf("%3d ", i);
    }
    printf("\n");
    printf("    ----------------------------------------\n");

   
    for (int i = 0; i < V; i++) {
        
        printf("%2d | ", i);
        
        for (int j = 0; j < V; j++) {
            printf("%3d ", matrix[i][j]);
        }
        printf("\n");
    }
}

int main() {
    Graph graphList;
    int graphMatrix[V][V];

    
    initGraph(&graphList);
    initMatrix(graphMatrix);

    
    int edges;
    printf("Enter the number of roads (edges) to construct: ");
    if (scanf("%d", &edges) != 1) return 1;

    printf("Enter edges in format (source destination weight):\n");
    printf("(Note: vertices should be between 0 and %d)\n", V - 1);
    
    for (int i = 0; i < edges; i++) {
        int u, v, w;
        scanf("%d %d %d", &u, &v, &w);
        
        
        if (u >= 0 && u < V && v >= 0 && v < V && w > 0) {
            addEdgeList(&graphList, u, v, w);
            addEdgeMatrix(graphMatrix, u, v, w);
            
           
        } else {
            printf("Invalid input. Edge ignored.\n");
        }
    }

    printList(&graphList);
    printMatrix(graphMatrix);

    // 3. Get the starting vertex
    int source;
    printf("Enter the source location (0 to %d): ", V - 1);
    scanf("%d", &source);

    if (source < 0 || source >= V) {
        printf("Invalid source vertex. Exiting...\n");
        return 1;
    }

    
    clock_t start = clock();
    
    for(int i = 0; i < 10000; i++) {
        DijkstraList(&graphList, source);
    }
    clock_t end = clock();
    double timeList = ((double)(end - start)) / CLOCKS_PER_SEC;


    
    start = clock();
    for(int i = 0; i < 10000; i++) {
        DijkstraMatrix(graphMatrix, source);
    }
    end = clock();
    double timeMatrix = ((double)(end - start)) / CLOCKS_PER_SEC;


    
    printf("\n--- Performance Evaluation (10,000 iterations) ---\n");
    printf("Adjacency List Execution Time:   %f seconds\n", timeList);
    printf("Adjacency Matrix Execution Time: %f seconds\n", timeMatrix);

    
    for (int i = 0; i < V; i++) {
        Node* current = graphList.head[i];
        while (current != NULL) {
            Node* temp = current;
            current = current->next;
            free(temp);
        }
    }

    return 0;
}

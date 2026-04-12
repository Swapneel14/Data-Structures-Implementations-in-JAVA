#include<stdio.h>
#include<stdlib.h>
#include<limits.h>

#define INF INT_MAX
#define V 10

typedef struct {

    int u;
    int v;
    int weight;

}Edge;

void BellmanFord(int E,Edge edges[],int src){
    int dist[V];

    for(int i = 0;i<V;i++){
        dist[i]=INF;
    }

    dist[src]=0;
    
    //V-1 Relaxations
    for(int i=1;i<=V-1;i++){
        for(int j = 0 ; j<E;j++){
            int u = edges[j].u;
            int v = edges[j].v;
            int weight = edges[j].weight;

            if(dist[u]!=INF&&dist[u]+weight<dist[v]){
                dist[v]=dist[u]+weight;
            }
        }
    }

    //Negative Cycle Detection

    for(int i = 0 ; i < E;i++){
        int u = edges[i].u;
            int v = edges[i].v;
            int weight = edges[i].weight;

            if(dist[u]!=INF&&dist[u]+weight<dist[v]){
                printf("Negative Cycle Detected!\n");
                printf("Cannot be produced Shortest Path Value");
                return ;
            }
    }

    printf("\nShortest path distances from Source Vertex %d:\n", src);
    for (int i = 0; i < V; i++) {
        if (dist[i] == INF) {
            printf("Vertex %d: Infinity (Unreachable)\n", i);
        } else {
            printf("Vertex %d: %d\n", i, dist[i]);
        }
    }


}

int main(){

    int E;
    printf("Enter the number of edges: ");
    if (scanf("%d", &E) != 1) return 1;

    
    Edge* edges = (Edge*)malloc(E * sizeof(Edge));

    printf("Enter each edge in the format (u v weight) v = [0,9]:\n");
    for (int i = 0; i < E; i++) {
        scanf("%d %d %d", &edges[i].u, &edges[i].v, &edges[i].weight);
    }

    int source;
    printf("Enter the source vertex (0 to %d): ", V - 1);
    scanf("%d", &source);

    
    BellmanFord(E, edges, source);

    
    free(edges);

    return 0;
    
}

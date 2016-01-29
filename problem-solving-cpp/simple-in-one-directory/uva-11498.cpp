#include <stdio.h>

int main() {
	int k, N, M, X, Y;
	while(scanf("%d",&k)!=EOF) {
		if(k == 0) break;
		scanf("%d%d",&N,&M);
		for(int i = 0; i < k; i++) {
			scanf("%d%d",&X,&Y);
			if(X == N || Y == M) {
				printf("divisa\n");
			} else if(X < N && Y > M) {
				printf("NO\n");
			} else if(X > N && Y > M) {
				printf("NE\n");
			} else if(X > N && Y < M) {
				printf("SE\n");
			} else if(X < N && Y < M) {
				printf("SO\n");
			}
		}
	}
}
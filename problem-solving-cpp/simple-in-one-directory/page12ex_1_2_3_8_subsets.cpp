#include <stdio.h>

#define N 3
int main() {
	int p[N];
	for(int i = 0; i < N; i++) {
		p[i] = i;
	}

	for(int i = 0; i < (1 <<N); i++) {
		for(int j = 0; j < N; j++) {
			if(i & (1 << j)) {
				printf("%d", p[j]);
			}
		}
		printf("\n");
	}
}

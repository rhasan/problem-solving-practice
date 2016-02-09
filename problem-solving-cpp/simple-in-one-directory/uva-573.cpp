#include <stdio.h>
int main() {
	int h; //H is the height of the well in feet
	int u; //U is the distance in feet that the snail can climb during the day
	int d; //D is the distance in feet that the snail slides down during the night
	int f; //F is the fatigue factor expressed as a percentage

	double ih, dc, haf, has, ff_val;

	while (scanf("%d%d%d%d", &h, &u, &d, &f) != EOF) {
		if(h == 0) break;
		ih = 0.0;
		dc = 0.0;
		haf = 0.0;
		has = 0.0;
		ff_val = (f/100.0) * u;
		int day = 1;
		bool success = false;
		while (1) {
			ih = has;
			dc = day == 1? u: dc - ff_val;
			dc = dc < 0.0? 0.0: dc;
			haf = ih + dc;
			has = haf - d;
			//printf("Day\tInitial Height\tDistance Climbed\tHeight After Climbing\tHeight\tAfter Sliding\n");
			//printf("%d\t%lf\t%lf\t\t%lf\t\t%lf\n", day, ih, dc, haf, has);
			if(haf > h) {
				success = true;
				break;
			} 
			if(has < 0 || haf < 0) {
				success = false;
				break;
			} 
			
			day++;
		}
		if(success) 
			printf("success on day %d\n", day);
		else printf("failure on day %d\n", day);

	}

	return 0;
}
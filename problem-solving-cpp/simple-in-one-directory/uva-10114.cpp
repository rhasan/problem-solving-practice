#include <stdio.h>

void printResult(int month) {
	if(month == 1)
		printf("1 month\n");
	else printf("%d months\n",month);
}

int main() {
	int months, depreciation_records, depreciation_counter, depreciation_month, month_counter;
	double down_payment, loan_amount, depreciation_percentage, depreciation_percentages[105], last_depreciation, total_car_value, current_car_value, current_due, monthly_payment;


	while(scanf("%d%lf%lf%d",&months, &down_payment, &loan_amount, &depreciation_records) != EOF) {
		
		if(months < 0) break;
		total_car_value = down_payment + loan_amount;
		monthly_payment = loan_amount/months;
		//printf("%d %lf %lf %d\n",months, down_payment, loan_amount, depreciation_records);

		for(month_counter = 0; month_counter <= months; month_counter++) {
			depreciation_percentages[month_counter] = -1.0;
		}

		for(depreciation_counter = 0; depreciation_counter < depreciation_records; depreciation_counter++) {
			scanf("%d%lf",&depreciation_month, &depreciation_percentage);
			depreciation_percentages[depreciation_month] = depreciation_percentage;
		}

		/*
		depreciation_percentage = depreciation_percentages[0];
		last_depreciation = depreciation_percentage;
		current_car_value = total_car_value - total_car_value * depreciation_percentage;
		current_due = loan_amount;
		if(current_car_value > current_due) {
			printResult(0);
		}*/
     	current_car_value = total_car_value;
     	current_due = loan_amount + monthly_payment;
		for(month_counter = 0; month_counter <= months; month_counter++) {
			if(depreciation_percentages[month_counter] == -1.0) {
				depreciation_percentage = last_depreciation;
			} else {
				depreciation_percentage = depreciation_percentages[month_counter];
				last_depreciation = depreciation_percentage;
			}
			current_car_value = current_car_value - current_car_value * depreciation_percentage;
			current_due = current_due - monthly_payment;
			if(current_car_value > current_due) {
				printResult(month_counter);
				break;
			}
		}
	}
}

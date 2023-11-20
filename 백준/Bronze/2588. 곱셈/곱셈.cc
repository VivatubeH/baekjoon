#include<iostream>

int main(){
	int x,y;
	std::cin >> x >> y;
	
	int temp = y;
	int num_100 = temp / 100;
	temp %= 100;
	int num_10 = temp / 10;
	temp %= 10;
	int num_1 = temp / 1;
	
	std::cout << x * num_1 << std::endl;
	std::cout << x * num_10 << std::endl;
	std::cout << x * num_100 << std::endl;
	std::cout << x*num_1 + x*10*num_10 + x*100*num_100 << std::endl;
	
	return 0;
}
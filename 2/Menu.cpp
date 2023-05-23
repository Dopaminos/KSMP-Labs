#include "Menu.h"

void showmenu() {
    std::cout << std::endl << "Лабораторная работа №2" << std::endl;
    std::cout << "1. Ввести точки" << std::endl;
    std::cout << "2. Вывести точки" << std::endl;
    std::cout << "3. Рассчитать площадь" << std::endl;
    std::cout << "4. Рассчитать периметр" << std::endl;
    std::cout << "5. Сохранить данные точек в файл" << std::endl;
    std::cout << "6. Загрузить точки из файла" << std::endl;
    std::cout << "7. Очистить поле от точек" << std::endl;
    std::cout << "0. Выйти из программы" << std::endl;
}

void menu() {
    int c = 1;
    while (c != 0) {
        showmenu();
        std::cin >> c;
        switch (c) {
        case 1:
            std::cout << "Ввести x и y: " << std::endl;
            addPoint();
            std::cout << std::endl;
            break;
        case 2:
            std::cout << "Координаты точек: " << std::endl;
            outPoint();
            break;
        case 3:
            std::cout << "Площадь: " << Area() << std::endl;
            break;
        case 4:
            std::cout << "Периметр: " << Perimeter() << std::endl;
            break;
        case 5:
            std::cout << "Выбранные точки сохранены в файл" << std::endl;
            writepol();
            break;
        case 6:
            std::cout << "Точки загружены из файла" << std::endl;
            readpol();
            break;
        case 7:
            std::cout << "Очистка введенных точек" << std::endl;
            clearPoint();
            break;
        case 0:
            std::cout << "Конец" << std::endl;
            break;
        default:
            std::cout << "Неверный ввод" << std::endl;
            break;
        }
    }
}

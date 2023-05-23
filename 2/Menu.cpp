#include "Menu.h"

void showmenu() {
    std::cout << std::endl << "������������ ������ �2" << std::endl;
    std::cout << "1. ������ �����" << std::endl;
    std::cout << "2. ������� �����" << std::endl;
    std::cout << "3. ���������� �������" << std::endl;
    std::cout << "4. ���������� ��������" << std::endl;
    std::cout << "5. ��������� ������ ����� � ����" << std::endl;
    std::cout << "6. ��������� ����� �� �����" << std::endl;
    std::cout << "7. �������� ���� �� �����" << std::endl;
    std::cout << "0. ����� �� ���������" << std::endl;
}

void menu() {
    int c = 1;
    while (c != 0) {
        showmenu();
        std::cin >> c;
        switch (c) {
        case 1:
            std::cout << "������ x � y: " << std::endl;
            addPoint();
            std::cout << std::endl;
            break;
        case 2:
            std::cout << "���������� �����: " << std::endl;
            outPoint();
            break;
        case 3:
            std::cout << "�������: " << Area() << std::endl;
            break;
        case 4:
            std::cout << "��������: " << Perimeter() << std::endl;
            break;
        case 5:
            std::cout << "��������� ����� ��������� � ����" << std::endl;
            writepol();
            break;
        case 6:
            std::cout << "����� ��������� �� �����" << std::endl;
            readpol();
            break;
        case 7:
            std::cout << "������� ��������� �����" << std::endl;
            clearPoint();
            break;
        case 0:
            std::cout << "�����" << std::endl;
            break;
        default:
            std::cout << "�������� ����" << std::endl;
            break;
        }
    }
}

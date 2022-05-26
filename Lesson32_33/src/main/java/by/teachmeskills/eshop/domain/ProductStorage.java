package by.teachmeskills.eshop.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductStorage {
    private static List<Product> products = Arrays.asList(new Product(1, "mobileApple.jpg",
                    "�������� Apple iPhone 13 128GB (������ ����)",
                    "Apple iOS, ����� 6.1'' OLED (1170x2532), Apple A15 Bionic, ��� 4 ��, ����-������ 128 ��, " +
                            "������ 12 ��, ����������� 3227 ���, 1 SIM",
                    new BigDecimal("2600"), 1),
            new Product(2, "mobileSamsung.jpg",
                    "�������� Samsung Galaxy A52 SM-A525F/DS 8GB/256GB (�����)",
                    "Android, ����� 6.5'' AMOLED (1080x2400), Qualcomm Snapdragon 720G, ��� 8 ��, ����-������ 256 ��," +
                            " ����� ������, ������ 64 ��, ����������� 4500 ���, 2 SIM",
                    new BigDecimal("1200"), 1),
            new Product(3, "laptopLenovo.jpg",
                    "������� ������� Lenovo Legion 5 15ACH6H 82JU00A1PB",
                    "15.6'' 1920 x 1080 IPS, 120 ��, �����������, AMD Ryzen 7 5800H 3200 ���, 16 �� DDR4," +
                            " SSD 512 ��, ���������� NVIDIA GeForce RTX 3060 6 ��, Windows 10, ���� ������ �����-�����",
                    new BigDecimal("5500"), 2),
            new Product(4, "laptopAcer.jpg",
                    "������� ������� Acer Nitro 5 AN515-45-R1A6 NH.QBREP.00B",
                    "15.6'' 1920 x 1080 IPS, 144 ��, �����������, AMD Ryzen 5 5600H 3300 ���, 16 �� DDR4," +
                            " SSD 1024 ��, ���������� NVIDIA GeForce RTX 3070 8 ��, Linux, ���� ������ ������",
                    new BigDecimal("5000"), 2),
            new Product(5, "navigatorGeofox.jpg",
                    "GPS ��������� GEOFOX MID502GPS",
                    "����� 5'' TFT (800 x 480), ��� 128 ��, ����-������ 8 ��, Windows CE 6.0",
                    new BigDecimal("222"), 3),
            new Product(6, "navigatorNavitel.jpg",
                    "GPS ��������� NAVITEL E707 Magnetic",
                    "����� 7'' TFT (800 x 480), ��������� MStar MSB2531 800 ���, ����-������ 8 ��, Linux",
                    new BigDecimal("342"), 3),
            new Product(7, "fridgeBosch.jpg",
                    "����������� Bosch Serie 6 VitaFresh Plus KGN39AI32R",
                    "���������������, ������ No Frost, " +
                            "����������� ����������, ����� A++, �������� �����: 388 � (280 + 108 �), " +
                            "����������� ����������, ���� ��������, ���������������� �����, �������� �����, " +
                            "����� ��� ����, ����� ��� ���, �������: ������ �� ����������, 60x66x203 ��, " +
                            "����������� �����",
                    new BigDecimal("2950"), 4),
            new Product(8, "fridgeSamsung.jpg",
                    "����������� Samsung RB37A52N0B1/WT",
                    "���������������, ������ No Frost, ����������� ����������, ����� A+, " +
                            "�������� �����: 367 � (269 + 98 �), ����������� ����������, ���������������� �����, " +
                            "����� ��� ���, 59.5x64.7x201 ��, ������",
                    new BigDecimal("2248"), 4),
            new Product(9, "carVolvo.jpg",
                    "Volvo XC40", "1.6 T3 MT Turbo Momentum",
                    new BigDecimal("87832"), 5),
            new Product(10, "carTesla.jpg",
                    "Tesla Model X",
                    "������������� ���������, P100D Long Range",
                    new BigDecimal("272107"), 5),
            new Product(11, "cameraCanon.jpg",
                    "���������� ����������� Canon EOS 4000D Kit 18-55mm III",
                    "���������� ������, ������� Canon EF-S, ������� APS-C (1.6 crop) 18 ��," +
                            " � ���������� F3.5-5.6 18-55 ��, Wi-Fi",
                    new BigDecimal("1449"), 6),
            new Product(12, "cameraNikon.jpg",
                    "���������� ����������� Nikon D5600 Kit 18-55mm AF-P DX VR",
                    "���������� ����������� Nikon D5600 Kit 18-55mm AF-P DX VR",
                    new BigDecimal("2550"), 6)
    );

    public static List<Product> getProducts() {
        return products;
    }

    public static Product getProductById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static List<Product> getProductsByCategoryId(int categoryId) {
        return products.stream()
                .filter(product -> product.getCategory_id() == categoryId)
                .collect(Collectors.toList());
    }
}

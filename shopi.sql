
CREATE DATABASE Shopi;

use Shopi;

drop database Shopi;

CREATE TABLE Role(
	RoleID INT PRIMARY KEY AUTO_INCREMENT,
	RoleName VARCHAR(50) NOT NULL UNIQUE,
	Description VARCHAR(255)
);

CREATE TABLE User (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    Username VARCHAR(50) NOT NULL UNIQUE,
    Password VARCHAR(30) NOT NULL,
    FullName VARCHAR(100) NOT NULL,
    RoleID INT NOT NULL,
    DateOfBirth DATE,
    Gender ENUM('Male', 'Female'),
    Email VARCHAR(100) NOT NULL UNIQUE,
    PhoneNumber double,
    Address VARCHAR(255),
    Wallet double DEFAULT 0.00,
    Status ENUM('Active', 'Inactive') DEFAULT 'Active',
    
    foreign key (RoleID) references role (RoleID)
);

CREATE TABLE VerityMoney(
	VerityMoneyID INT PRIMARY KEY AUTO_INCREMENT,
	UserID INT NOT NULL,
	Money double DEFAULT 0.00,
	Status ENUM('Active', 'Inactive') DEFAULT 'Active',
    
    foreign key (UserID) references User (userID)
);

CREATE TABLE Supplier(
	SupplierID INT PRIMARY KEY AUTO_INCREMENT,
	SupplierName VARCHAR(50) NOT NULL UNIQUE,
	Address VARCHAR(255),
	Status ENUM('Active', 'Inactive') DEFAULT 'Active'
);

CREATE TABLE CategoryProduct(
 CategoryID INT PRIMARY KEY AUTO_INCREMENT,
 CategoryName VARCHAR(50) NOT NULL UNIQUE,
 Description VARCHAR(255),
 Status ENUM('Active', 'Inactive') DEFAULT 'Active'
);

CREATE TABLE Products(
	ProductID INT PRIMARY KEY AUTO_INCREMENT,
	ProductName VARCHAR(50) NOT NULL UNIQUE,
	CategoryID INT NOT NULL,
	SupplierID INT NOT NULL,
	Price double DEFAULT 0.00,
	Quantity INT NOT NULL CHECK (Quantity >= 0),
	Description VARCHAR(255),
	Status ENUM('Active', 'Inactive') DEFAULT 'Active',
    
    foreign key (SupplierID) references Supplier (SupplierID),
    foreign key (CategoryID) references CategoryProduct (CategoryID)
);

CREATE TABLE Cart(
	CartID INT PRIMARY KEY AUTO_INCREMENT,
	UserID INT NOT NULL,
	QuantityProduct INT NOT NULL CHECK (QuantityProduct > 0),
	TotalPrice double,
    
    foreign key (UserID) references User (UserID)
);

CREATE TABLE CartDetails(
	CartDetailID INT PRIMARY KEY AUTO_INCREMENT,
	CartID INT NOT NULL,
	ProductID INT NOT NULL,
	Quantity INT NOT NULL CHECK (Quantity >= 0),
	Price double DEFAULT 0.00,
    
    foreign key (CartID) references Cart (CartID),
    foreign key (ProductID) references Products (ProductID)
);

CREATE TABLE Bill(
	BillID INT PRIMARY KEY AUTO_INCREMENT,
	UserID INT NOT NULL,
	TotalAmount double DEFAULT 0.00,
	BillDate DATE,
    
    foreign key (UserID) references User (UserID)
);

CREATE TABLE BillDetail(
	BillDetailID  INT PRIMARY KEY AUTO_INCREMENT,
	BillID INT NOT NULL,
	ProductID INT NOT NULL,
	Quantity INT NOT NULL CHECK (Quantity >= 0),
	Price double DEFAULT 0.00,
	TotalPrice double DEFAULT 0.00,
    
    foreign key (BillID) references Bill (BillID),
    foreign key (ProductID) references Products (ProductID)
);


INSERT INTO Role (RoleName, Description) VALUES
('Quản lý', 'Quản trị viên có toàn quyền truy cập vào hệ thống'),
('Khách hàng', 'Người mua có quyền truy cập mua sản phẩm từ web'),
('Người bán', 'Người bán có quyền thêm sản phẩm để bán');

select * from role;

-- Thêm 10 dữ liệu vào bảng User
INSERT INTO User (Username, Password, FullName, RoleID, DateOfBirth, Gender, Email, PhoneNumber, Address, Wallet, Status) VALUES
('an1109', '0123', 'Phạm Hoàng An', 1, '2001-11-09', 'Male', 'phamhoangan1109@gmail.com', 1234567890, '123 Quận 7',900000, 'Active'),
('tri0311', '1234', 'Nguyễn Hữu Trí', 3, '2003-11-03', 'Male', 'nguyenhuutri0311@gamil.com', 2345678901, '456 banahiu', 150500, 'Active'),
('tien2612', '1234', 'Khúc Thị Thủy Tiên', 3, '1985-12-26', 'Female', 'khucthithuytien2612@gamil.com', 3456789012, '789 Hà Nội', 200000, 'Active'),
('long1910', '1234', 'Nguyễn Danh Long', 3, '2000-10-19', 'Male', 'nguyendanhlong1910@gmail.com', 4567890123, '101 Pine St', 250000, 'Inactive'),
('sanh0509', '2345', 'Mai Văn Sanh', 2, '1993-09-05', 'Male', 'maivansanhsanh0509@gmail.com', 5678901234, '202 tp Thủ Đức', 0, 'Active'),
('hung2310', '2345', 'Kiều Hưng', 2, '2006-10-23', 'Male', 'kieuhung2310@gmailcom', 6789012345, '303 Hà Đông', 0, 'Active'),
('quang1508', '2345', 'Nguyễn Phú Quang', 2, '2002-08-15', 'Male', 'nguyenphuquang1508@gmail.com', 7890123456, '404 Tân bình', 0, 'Active'),
('thanh1012', '2345', 'Sĩ Thanh', 2, '1986-12-10', 'Female', 'sithanh1012@gmail.com', 8901234567, '505 Quận 3', 0, 'Active'),
('trung3110', '2345', 'Trần Quốc Trung', 2, '1994-10-31', 'Male', 'tranquoctrung3110@gmail.com', 9012345678, '606 Tân Phú', 0, 'Active'),
('trinh2709', '2345', 'Trần Thị Ngọc Trinh', 2, '1989-09-27', 'Female', 'tranthingoctrinh2709@gmail.com', 1230987654, '707 Quận 2', 0, 'Inactive');


select * from User;

INSERT INTO Supplier (SupplierName, Address, Status) VALUES
('Apple', '123 USA', 'Active'),
('Samsung', '456 Korea', 'Active'),
('Xiaomi', '789 Trung Quốc', 'Active'),
('OPPO', '101 Trung Quốc', 'Active'),
('vivo', '202 Trung Quốc', 'Active'),
('HONOR', '303 Trung Quốc', 'Active'),
('Nokia', '404 Phần Lan', 'Active'),
('Huawei', '505 Trung Quốc', 'Active'),
('Realme', '606 Trung Quốc', 'Inactive'),
('Transsion', '707 Trung Quốc', 'Inactive'),
('Asus', '521 Đài Loan', 'Active'),
('Acer', '305 Đài Loan', 'Active');

select * from Supplier;

INSERT INTO CategoryProduct (CategoryName, Description, Status) VALUES
('Điện thoại', 'Các loại điện thoại thông minh và điện thoại di động', 'Active'),
('Laptop', 'Các dòng máy tính xách tay và phụ kiện đi kèm', 'Active'),
('Tablet', 'Máy tính bảng từ nhiều hãng khác nhau', 'Active'),
('Phụ kiện di động', 'Các phụ kiện dành cho điện thoại di động như ốp lưng, tai nghe, sạc dự phòng', 'Active'),
('Phụ kiện laptop', 'Các phụ kiện dành cho máy tính xách tay như túi đựng, chuột, bàn phím', 'Active'),
('Thiết bị âm thanh', 'Các thiết bị âm thanh như loa, tai nghe, dàn âm thanh', 'Active'),
('Thiết bị lưu trữ', 'Các thiết bị lưu trữ dữ liệu như ổ cứng, USB, thẻ nhớ', 'Active'),
('Robot', 'Các loại robot công nghệ cao cho gia đình và công nghiệp', 'Inactive'),
('Dịch vụ tiện ích', 'Các dịch vụ tiện ích như bảo hiểm, bảo hành, sửa chữa', 'Inactive');

select * from CategoryProduct;

INSERT INTO Products (ProductName, CategoryID, SupplierID, Price, Quantity, Description, Status) VALUES
-- Mobile Phones (15)
('iPhone 15 Pro Max', 1, 1, 29990000.00, 50, 'Điện thoại Apple iPhone 15 Pro Max 512G', 'Active'),
('Samsung Galaxy S21', 1, 2, 20990000.00, 40, 'Điện thoại Samsung Galaxy S21', 'Active'),
('OPPO Reno6', 1, 4, 12990000.00, 60, 'Điện thoại OPPO Reno6', 'Active'),
('Xiaomi Mi 11', 1, 3, 17990000.00, 30, 'Điện thoại Xiaomi Mi 11', 'Active'),
('Vivo V21', 1, 5, 10990000.00, 45, 'Điện thoại Vivo V21', 'Active'),
('Xiaomi Redmi Note 13 Pro', 1, 3, 8990000.00, 55, 'Điện thoại Xiaomi Redmi Note 13 Pro 8GB/128GB', 'Active'),
('Nokia X10', 1, 7, 7990000.00, 35, 'Điện thoại Nokia X10', 'Active'),
('Samsung Galaxy Z Fold5', 1, 2, 20990000.00, 25, 'Điện thoại Samsung Galaxy Z Fold5 5G 12GB/256GB', 'Active'),
('iPhone 14 Pro Max', 1, 1, 24990000.00, 20, 'Điện thoại iPhone 14 Pro Max 1T', 'Active'),
('Xiaomi 14 Ultra', 1, 3, 18990000.00, 40, 'Điện thoại Xiaomi 14 Ultra 16GB/512GB', 'Active'),
('Huawei P40 Pro', 1, 8, 21990000.00, 30, 'Điện thoại Huawei P40 Pro', 'Active'),
('Asus ROG Phone 5', 1, 12, 29990000.00, 15, 'Điện thoại Asus ROG Phone 5', 'Active'),
('Xiaomi Redmi Note 10', 1, 3, 5990000.00, 70, 'Điện thoại Xiaomi Redmi Note 10', 'Active'),
('Samsung Galaxy A52', 1, 2, 10990000.00, 50, 'Điện thoại Samsung Galaxy A52', 'Active'),
('OPPO A74', 1, 4, 6990000.00, 65, 'Điện thoại OPPO A74', 'Active'),

-- Laptops (8)
('MacBook Air M1', 2, 1, 29990000.00, 25, 'Laptop Apple MacBook Air M1', 'Active'),
('MacBook Pro 16 inch M3', 2, 1, 25990000.00, 20, 'Laptop Apple MacBook Pro 16 inch M3 Pro', 'Active'),
('Asus TUF Gaming A15', 2, 11, 19990000.00, 30, 'Laptop Asus TUF Gaming A15 FA506NF R5', 'Active'),
('Asus ZenBook 14', 2, 11, 18990000.00, 35, 'Laptop Asus ZenBook 14', 'Active'),
('Asus Vivobook 16', 2, 11, 29990000.00, 15, 'Laptop Asus Vivobook 16 X1605VA i5', 'Active'),
('Acer Aspire 5', 2, 12, 15990000.00, 25, 'Laptop Acer Aspire 5', 'Active'),
('Acer Gaming Nitro 5 Tiger', 2, 12, 26990000.00, 20, 'Laptop Acer Gaming Nitro 5 Tiger AN515 58 52SP i5', 'Active'),
('Acer Gaming Nitro V', 2, 12, 23990000.00, 20, 'Laptop Acer Gaming Nitro V ANV15 51 57B2 i5', 'Active'),

-- Tablets (5)
('Samsung Galaxy Tab S7', 3, 2, 16990000.00, 40, 'Máy tính bảng Samsung Galaxy Tab S7', 'Active'),
('Samsung Galaxy Tab S6 Lite', 3, 1, 16990000.00, 50, 'Máy tính bảng Samsung Galaxy Tab S6 Lite (2024)', 'Active'),
('iPad Pro M4', 3, 1, 14990000.00, 30, 'Máy tính bảng iPad Pro M4 11 inch WiFi 256GB', 'Active'),
('iPad Air 6 M2', 3, 1, 24990000.00, 20, 'Máy tính bảng iPad Air 6 M2 11 inch WiFi 128GB', 'Active'),
('Xiaomi Redmi Pad SE', 3, 3, 11990000.00, 35, 'Máy tính bảng Xiaomi Redmi Pad SE (4GB/128GB)', 'Active'),

-- Mobile Accessories (5)
('AirPods Pro 2 Nhựa', 4, 1, 5490000.00, 120, 'Túi đựng AirPods Pro 2 Nhựa cứng viền dẻo Laut HUEX PASTEL', 'Active'),
(' Tab A9 Samsung', 4, 2, 4990000.00, 110, 'Bao da Galaxy Tab A9 Samsung Chính hãng', 'Active'),
('Type C PD 45W Samsung', 4, 2, 799000.00, 200, 'Pin sạc dự phòng 20000mAh Type C PD 45W Samsung EB-P4520', 'Active'),
('Magsafe iPhone 15 Pro Max', 4, 1, 6990000.00, 80, 'Ốp lưng Magsafe iPhone 15 Pro Max Vải tinh dệt Apple', 'Active'),
('Samsung S Pen Pro', 4, 2, 990000.00, 150, 'Bút cảm ứng Samsung S Pen Pro EJ-P5450 Đen', 'Active'),

-- Laptop Accessories (5)
('Apple MK2E3', 5, 1, 2299000.00, 100, 'Chuột Bluetooth Apple MK2E3', 'Active'),
('ASUS ROG Gladius III', 5, 11, 1699000.00, 80, 'Chuột Gaming ASUS ROG Gladius III', 'Active'),
('Asus ROG Strix Scope', 5, 11, 2990000.00, 60, 'Bàn phím Có Dây Gaming Asus ROG Strix Scope NX TKL DELUXE RD SW', 'Active'),
('Asus AX1800HP', 5, 11, 3999000.00, 40, 'Router Wifi Chuẩn Wifi 6 Asus AX1800HP', 'Active'),
('Xiaomi HLK404', 5, 3, 1299000.00, 90, 'Chuột Bluetooth Silent Xiaomi HLK404', 'Active'),

-- Audio Devices (5)
('AirPods Pro Gen 2', 6, 1, 2990000.00, 80, 'Tai nghe Bluetooth AirPods Pro Gen 2 MagSafe Charge', 'Active'),
('Samsung HW-B650D/XV', 6, 2, 2490000.00, 90, 'Loa Thanh Samsung HW-B650D/XV 370W', 'Active'),
('Xiaomi Redmi Buds 5 Pro', 6, 3, 5990000.00, 50, 'Tai nghe Bluetooth True Wireless Xiaomi Redmi Buds 5 Pro', 'Active'),
('Asus Rog Cetra', 6, 11, 8490000.00, 30, 'Tai nghe Bluetooth True Wireless Gaming Asus Rog Cetra', 'Active'),
('OPPO ENCO Buds 2', 6, 4, 3990000.00, 70, 'Tai nghe Bluetooth True Wireless OPPO ENCO Buds 2 ETE41', 'Active'),

-- Storage Devices (5)
('SanDisk Ultra 128GB', 7, 5, 299000.00, 300, 'Thẻ nhớ SanDisk Ultra 128GB', 'Active'),
('Samsung T5 Portable SSD 1TB', 7, 2, 3499000.00, 60, 'Ổ cứng di động SSD Samsung T5 1TB', 'Active'),
('Kingston DataTraveler 64GB', 7, 6, 499000.00, 150, 'USB Kingston DataTraveler 64GB', 'Active'),
('Seagate Backup Plus 2TB', 7, 7, 2499000.00, 80, 'Ổ cứng di động Seagate Backup Plus 2TB', 'Active'),
('Transcend StoreJet 1TB', 7, 8, 1999000.00, 70, 'Ổ cứng di động Transcend StoreJet 1TB', 'Active');

select * from Products;

INSERT INTO Cart (UserID, QuantityProduct, TotalPrice) VALUES
(5, 3, 89970000.00),
(6, 2, 24890000.00),
(7, 4, 29990000.00),
(9, 5, 16990000.00);

select * from Cart;

INSERT INTO CartDetails (CartID, ProductID, Quantity, Price) VALUES 
(1, 1, 3, 29990000.00), 
(2, 2, 1, 20990000.00), 
(2, 45, 1, 3499000.00), 
(3, 3, 2, 12990000.00), 
(3, 1, 1, 10495000.00), 
(3, 1, 1, 7497500.00);
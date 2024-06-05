
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
    Wallet DECIMAL(10, 2) DEFAULT 0.00,
    Status ENUM('Active', 'Inactive') DEFAULT 'Active',
    
    foreign key (RoleID) references role (RoleID)
);

CREATE TABLE VerityMoney(
	VerityMoneyID INT PRIMARY KEY AUTO_INCREMENT,
	UserID INT NOT NULL,
	Money DECIMAL(10, 2) DEFAULT 0.00,
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

CREATE TABLE VerityProduct(
	VerityProductID INT PRIMARY KEY AUTO_INCREMENT,
	UserID INT NOT NULL,
	SupplierID INT NOT NULL,
	CategoryID INT NOT NULL,
	ProductName VARCHAR(50) NOT NULL UNIQUE,
	Status ENUM('Active', 'Inactive') DEFAULT 'Active',
    
    foreign key (UserID) references User (UserID),
    foreign key (SupplierID) references Supplier (SupplierID),
    foreign key (CategoryID) references CategoryProduct (CategoryID)

);

CREATE TABLE Products(
	ProductID INT PRIMARY KEY AUTO_INCREMENT,
	ProductName VARCHAR(50) NOT NULL UNIQUE,
	CategoryID INT NOT NULL,
	SupplierID INT NOT NULL,
	Price DECIMAL(10, 2) DEFAULT 0.00,
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
	TotalPrice DECIMAL(10, 2) DEFAULT 0.00,
    
    foreign key (UserID) references User (UserID)
);

CREATE TABLE CartDetails(
	CartDetailID INT PRIMARY KEY AUTO_INCREMENT,
	CartID INT NOT NULL,
	ProductID INT NOT NULL,
	Quantity INT NOT NULL CHECK (Quantity >= 0),
	Price DECIMAL(10, 2) DEFAULT 0.00,
    
    foreign key (CartID) references Cart (CartID),
    foreign key (ProductID) references Products (ProductID)
);

CREATE TABLE Bill(
	BillID INT PRIMARY KEY AUTO_INCREMENT,
	UserID INT NOT NULL,
	TotalAmount DECIMAL(10, 2) DEFAULT 0.00,
	BillDate DATE,
    
    foreign key (UserID) references User (UserID)
);

CREATE TABLE BillDetail(
	BillDetailID  INT PRIMARY KEY AUTO_INCREMENT,
	BillID INT NOT NULL,
	ProductID INT NOT NULL,
	Quantity INT NOT NULL CHECK (Quantity >= 0),
	Price DECIMAL(10, 2) DEFAULT 0.00,
	TotalPrice DECIMAL(10, 2) DEFAULT 0.00,
    
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
('tri0311', '1234', 'Nguyễn Hữu Trí', 2, '2003-11-03', 'Male', 'nguyenhuutri0311@gamil.com', 2345678901, '456 banahiu', 150500, 'Active'),
('tien2612', '1234', 'Khúc Thị Thủy Tiên', 2, '1985-12-26', 'Female', 'khucthithuytien2612@gamil.com', 3456789012, '789 Hà Nội', 200000, 'Active'),
('long1910', '1234', 'Nguyễn Danh Long', 2, '2000-10-19', 'Male', 'nguyendanhlong1910@gmail.com', 4567890123, '101 Pine St', 250000, 'Inactive'),
('sanh0509', '2345', 'Mai Văn Sanh', 3, '1993-09-05', 'Male', 'maivansanhsanh0509@gmail.com', 5678901234, '202 tp Thủ Đức', 0, 'Active'),
('hung2310', '2345', 'Kiều Hưng', 3, '2006-10-23', 'Male', 'kieuhung2310@gmailcom', 6789012345, '303 Hà Đông', 0, 'Active'),
('quang1508', '2345', 'Nguyễn Phú Quang', 3, '2002-08-15', 'Male', 'nguyenphuquang1508@gmail.com', 7890123456, '404 Tân bình', 0, 'Active'),
('thanh1012', '2345', 'Sĩ Thanh', 3, '1986-12-10', 'Female', 'sithanh1012@gmail.com', 8901234567, '505 Quận 3', 0, 'Active'),
('trung3110', '2345', 'Trần Quốc Trung', 3, '1994-10-31', 'Male', 'tranquoctrung3110@gmail.com', 9012345678, '606 Tân Phú', 0, 'Active'),
('trinh2709', '2345', 'Trần Thị Ngọc Trinh', 3, '1989-09-27', 'Female', 'tranthingoctrinh2709@gmail.com', 1230987654, '707 Quận 2', 0, 'Inactive');


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
('Transsion', '707 Trung Quốc', 'Inactive');

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

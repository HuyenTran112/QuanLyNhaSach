﻿CREATE DATABASE QUANLYNHASACH
GO
--TẠO BẢNG KHACHHANG
CREATE TABLE KHACHHANG
(
	MAKH INT,
	TENKH NVARCHAR(100),
	DIACHI NVARCHAR(200),
	SODT NVARCHAR(10),
	NGAYSINH SMALLDATETIME,
	NGAYDKY SMALLDATETIME,
	DOANHSO MONEY,
	PRIMARY KEY(MAKH)
)
GO
--TẠO BẢNG SACH
CREATE TABLE SACH
(
	MASACH INT,
	TENSACH NVARCHAR(100),
	NHAXUATBAN NVARCHAR(100),
	NAMXUATBAN INT,
	TOMTAT NVARCHAR(200),
	GIABAN MONEY,
	GIANHAP MONEY,
	TONGSACHTON INT,
	MATHELOAI INT,
	PRIMARY KEY(MASACH)
)
GO
--TẠO BẢNG LOAISACH
CREATE TABLE LOAISACH
(
	MATHELOAI INT,
	TENTHELOAI NVARCHAR(100),
	PRIMARY KEY(MATHELOAI)
)
GO
--TẠO BẢNG TACGIA
CREATE TABLE TACGIA
(
	MATG INT,
	TENTG NVARCHAR(100),
	PRIMARY KEY(MATG)
)
GO
--TẠO BẢNG CT_SACH_TACGIA
CREATE TABLE CT_SACH_TACGIA
(
	MASACH INT,
	MATG INT,
	PRIMARY KEY(MASACH, MATG)
)
GO
--TẠO BẢNG NHANVIEN
CREATE TABLE NHANVIEN
(
	MANV INT,
	TENNV NVARCHAR(100),
	DIACHI NVARCHAR(200),
	SODT NVARCHAR(10),
	NGAYVL SMALLDATETIME,
	PRIMARY KEY(MANV)
)
GO
--TẠO BẢNG HOADON
CREATE TABLE HOADON
( 
	SOHD INT,
	NGAYHD SMALLDATETIME,
	MAKH INT,
	MANV INT,
	VAT FLOAT,
	TRIGIA MONEY,
	TONGTIEN MONEY,
	PRIMARY KEY(SOHD)
)
GO
--TẠO BẢNG CTHD
CREATE TABLE CTHD
(
	SOHD INT,
	MASACH INT,
	SOLUONG INT,
	THANHTIEN MONEY,
	PRIMARY KEY(SOHD, MASACH)
)
GO
--TẠO BẢNG CONGTY
CREATE TABLE CONGTY
(
	MACTY INT,
	TENCTY NVARCHAR(100),
	DIACHI NVARCHAR(200),
	SODT NVARCHAR(10),
	PRIMARY KEY(MACTY)
)
GO
--TẠO BẢNG PHIEUNHAP
CREATE TABLE PHIEUNHAP
(
	SOPHIEUNHAP INT,
	NGAYNHAP SMALLDATETIME,
	MACTY INT,
	TONGTIEN MONEY,
	PRIMARY KEY(SOPHIEUNHAP)
)
GO
--TẢO BẢNG CT_PHIEUNHAP
CREATE TABLE CT_PHIEUNHAP
(
	SOPHIEUNHAP INT,
	MASACH INT,
	SOLUONGNHAP INT,
	THANHTIEN MONEY,
	PRIMARY KEY(SOPHIEUNHAP, MASACH)
)
GO
--TẠO BẢNG KHUYENMAI
CREATE TABLE KHUYENMAI
(
	MAKM INT,
	TENKM NVARCHAR(100),
	TUMUCTIEN MONEY,
	DENMUCTIEN MONEY,
	NGAYBD SMALLDATETIME,
	NGAYKT SMALLDATETIME,
	HESOKM FLOAT,
	PRIMARY KEY(MAKM)
)
GO
--TẠO BẢNG NGUOIDUNG
CREATE TABLE CHUCNANG
(
	MACHUCNANG INT PRIMARY KEY,
	TENCHUCNANG NVARCHAR(100) NOT NULL,
	TENMANHINHDUOCLOAD VARCHAR(100) NOT NULL
)
GO
--TẠO BẢNG NHOMNGUOIDUNG
CREATE TABLE NHOMNGUOIDUNG
(
	MANHOM INT PRIMARY KEY,
	TENNHOM NVARCHAR(100) NOT NULL,
)
GO
--TẠO BẢNG PHANQUYEN
CREATE TABLE PHANQUYEN
(
	MANHOM INT ,
	MACHUCNANG INT ,
	PRIMARY KEY(MANHOM,MACHUCNANG)
)
GO
--TẠO BẢNG NGUOIDUNG
CREATE TABLE NGUOIDUNG
(
	TENDANGNHAP VARCHAR(100) NOT NULL DEFAULT '' PRIMARY KEY,
	TENHIENTHI NVARCHAR(100),
	MATKHAU VARCHAR(100) NOT NULL DEFAULT '',
	MANHOM INT NOT NULL
)
GO
--TẠO KHÓA NGOẠI
ALTER TABLE SACH ADD CONSTRAINT FK_SACH_THELOAI  FOREIGN KEY(MATHELOAI) REFERENCES LOAISACH(MATHELOAI)
GO
ALTER TABLE CT_SACH_TACGIA ADD CONSTRAINT FK_CT_SACH_TACGIA_SACH FOREIGN KEY(MASACH) REFERENCES SACH(MASACH)
GO
ALTER TABLE CT_SACH_TACGIA ADD CONSTRAINT FK_CT_SACH_TACGIA_TACGIA FOREIGN KEY(MATG) REFERENCES TACGIA(MATG)
GO
ALTER TABLE HOADON ADD CONSTRAINT FK_HOADON_KHACHHANG FOREIGN KEY(MAKH) REFERENCES KHACHHANG(MAKH)
GO
ALTER TABLE HOADON ADD CONSTRAINT FK_HOADON_NHANVIEN FOREIGN KEY(MANV) REFERENCES NHANVIEN(MANV)
GO
ALTER TABLE CTHD ADD CONSTRAINT FK_CTHD_HOADON FOREIGN KEY(SOHD) REFERENCES HOADON(SOHD)
GO
ALTER TABLE CTHD ADD CONSTRAINT FK_CTHD_SACH FOREIGN KEY (MASACH) REFERENCES SACH(MASACH)
GO
ALTER TABLE CT_PHIEUNHAP ADD CONSTRAINT FK_CT_PHIEUNHAP_PHIEUNHAP FOREIGN KEY(SOPHIEUNHAP) REFERENCES PHIEUNHAP(SOPHIEUNHAP)
GO
ALTER TABLE CT_PHIEUNHAP ADD CONSTRAINT FK_CT_PHIEUNHAP_SACH FOREIGN KEY(MASACH) REFERENCES SACH(MASACH)
GO
ALTER TABLE PHIEUNHAP ADD CONSTRAINT FK_PHIEUNHAP_CONGTY FOREIGN KEY(MACTY) REFERENCES CONGTY(MACTY)
GO
ALTER TABLE PHANQUYEN ADD CONSTRAINT FK_PHANQUYEN_NHOM FOREIGN KEY (MANHOM) REFERENCES NHOMNGUOIDUNG(MANHOM)
GO
ALTER TABLE PHANQUYEN ADD CONSTRAINT FK_PHANQUYEN_CHUCNANG FOREIGN KEY (MACHUCNANG) REFERENCES CHUCNANG(MACHUCNANG)
GO
--Stored Procedure Xuất thông tin sách
CREATE PROC SP_LOADBOOK
AS
BEGIN
	SELECT MASACH, TENTHELOAI,TENSACH, NHAXUATBAN, NAMXUATBAN, TOMTAT, GIABAN, GIANHAP, TONGSACHTON
	FROM SACH, LOAISACH
	WHERE SACH.MATHELOAI=LOAISACH.MATHELOAI
END
GO
EXEC SP_LOADBOOK
GO
--Stored Procedure Xuất tên thể loại sách
CREATE PROC SP_LOADBOOKCATEGOGY
AS
BEGIN
	SELECT MATHELOAI,TENTHELOAI
	FROM LOAISACH
END
GO
EXEC SP_LOADBOOKCATEGOGY
GO
--Stored Produre thêm sách
SELECT * FROM SACH
GO
ALTER PROC SP_INSERTBOOK
@TENSACH NVARCHAR (100), @NHAXUATBAN NVARCHAR(100), @NAMXUATBAN INT, @TOMTAT NVARCHAR(200), @GIABAN MONEY, @GIANHAP MONEY, @TONGSACHTON INT, @MATHELOAI INT
AS
BEGIN
	DECLARE @MASACH INT, @MASACH_MAX INT, @I INT
	SET @I=1
	SET @MASACH_MAX=(SELECT MAX(MASACH)
	FROM SACH)
	WHILE(@I<=@MASACH_MAX)
		BEGIN
			IF((SELECT COUNT(*)
				FROM SACH
				WHERE MASACH=@I)=0)
				BEGIN
					INSERT INTO SACH VALUES( @I,@TENSACH, @NHAXUATBAN,@NAMXUATBAN,@TOMTAT,@GIABAN,@GIANHAP,@TONGSACHTON,@MATHELOAI)
					BREAK;
				END
				SET @I=@I+1
		END
	IF(@I>@MASACH_MAX)
	BEGIN
		SET @MASACH=@MASACH_MAX+1
		INSERT INTO SACH VALUES(@MASACH,@TENSACH, @NHAXUATBAN,@NAMXUATBAN,@TOMTAT,@GIABAN,@GIANHAP,@TONGSACHTON,@MATHELOAI)
	END
END
GO
EXEC SP_INSERTBOOK N'Hệ quản trị cơ sỡ dữ liệu',N'Đại học quốc gia',2017,'',100000,80000,10,7
GO
SELECT * FROM LOAISACH
GO
SELECT * FROM SACH
GO
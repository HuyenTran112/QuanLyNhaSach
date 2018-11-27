﻿CREATE DATABASE QUANLYNHASACH
GO
--TẠO BẢNG KHACHHANG
CREATE TABLE KHACHHANG
(
	MAKH INT,
	TENKH NVARCHAR(100) NOT NULL DEFAULT '',
	DIACHI NVARCHAR(200)NOT NULL DEFAULT '',
	SODT NVARCHAR(10) NOT NULL DEFAULT '',
	NGAYSINH SMALLDATETIME NOT NULL DEFAULT GETDATE(),
	NGAYDKY SMALLDATETIME NOT NULL DEFAULT GETDATE(),
	DOANHSO MONEY NOT NULL DEFAULT 0,
	PRIMARY KEY(MAKH)
)
GO
--TẠO BẢNG SACH
CREATE TABLE SACH
(
	MASACH INT,
	TENSACH NVARCHAR(100) NOT NULL DEFAULT '',
	TACGIA NVARCHAR(100) NOT NULL DEFAULT '',
	NHAXUATBAN NVARCHAR(100) NOT NULL DEFAULT '',
	NAMXUATBAN INT NOT NULL DEFAULT YEAR(GETDATE()),
	TOMTAT NVARCHAR(200) NOT NULL DEFAULT '',
	GIANHAP MONEY NOT NULL DEFAULT 0,
	TONGSACHTON INT NOT NULL DEFAULT 0,
	MATHELOAI INT NOT NULL ,
	PRIMARY KEY(MASACH)
)
GO
--TẠO BẢNG LOAISACH
CREATE TABLE LOAISACH
(
	MATHELOAI INT,
	TENTHELOAI NVARCHAR(100)NOT NULL DEFAULT '',
	PRIMARY KEY(MATHELOAI)
)
GO
--TẠO BẢNG NHANVIEN
CREATE TABLE NHANVIEN
(
	MANV INT,
	TENNV NVARCHAR(100) NOT NULL DEFAULT '',
	NGAYSINH SMALLDATETIME NOT NULL DEFAULT GETDATE(),
	GIOITINH NVARCHAR(100) NOT NULL DEFAULT '',
	DIACHI NVARCHAR(200)NOT NULL DEFAULT '',
	SODT NVARCHAR(10)NOT NULL DEFAULT '',
	NGAYVL SMALLDATETIME NOT NULL DEFAULT GETDATE(),
	TRANGTHAI INT DEFAULT 0,
	PRIMARY KEY(MANV)
)
GO
--TẠO BẢNG HOADON
CREATE TABLE HOADON
( 
	SOHD INT,
	NGAYHD SMALLDATETIME NOT NULL DEFAULT GETDATE(),
	MAKH INT ,
	MANV INT NOT NULL,
	VAT FLOAT NOT NULL DEFAULT 0,
	TRIGIA MONEY NOT NULL DEFAULT 0,
	TONGTIEN MONEY NOT NULL DEFAULT 0,
	HESOKM FLOAT,
	PRIMARY KEY(SOHD)
)
GO
--TẠO BẢNG CTHD
CREATE TABLE CTHD
(
	SOHD INT,
	MASACH INT,
	SOLUONG INT NOT NULL DEFAULT 0,
	GIABAN MONEY NOT NULL DEFAULT 0,
	THANHTIEN MONEY NOT NULL DEFAULT 0,
	PRIMARY KEY(SOHD, MASACH)
)
GO
--TẠO BẢNG CONGTY
CREATE TABLE CONGTY
(
	MACTY INT,
	TENCTY NVARCHAR(100) NOT NULL DEFAULT '',
	DIACHI NVARCHAR(200) NOT NULL DEFAULT '',
	SODT NVARCHAR(10) NOT NULL DEFAULT '',
	PRIMARY KEY(MACTY)
)
GO
--TẠO BẢNG PHIEUNHAP
CREATE TABLE PHIEUNHAP
(
	SOPHIEUNHAP INT,
	NGAYNHAP SMALLDATETIME NOT NULL DEFAULT GETDATE(),
	MACTY INT NOT NULL ,
	TONGTIEN MONEY NOT NULL DEFAULT 0,
	PRIMARY KEY(SOPHIEUNHAP)
)
GO
--TẢO BẢNG CT_PHIEUNHAP
CREATE TABLE CT_PHIEUNHAP
(
	SOPHIEUNHAP INT,
	MASACH INT,
	SOLUONGNHAP INT NOT NULL DEFAULT 0,
	GIANHAP MONEY DEFAULT 0,
	THANHTIEN MONEY NOT NULL DEFAULT 0,
	PRIMARY KEY(SOPHIEUNHAP, MASACH)
)
GO
--TẠO BẢNG KHUYENMAI
CREATE TABLE KHUYENMAI
(
	MAKM INT,
	TENKM NVARCHAR(100) NOT NULL DEFAULT '',
	MUCTIEN MONEY NOT NULL DEFAULT 0,
	NGAYBD SMALLDATETIME NOT NULL DEFAULT GETDATE(),
	NGAYKT SMALLDATETIME NOT NULL DEFAULT GETDATE(),
	HESOKM FLOAT NOT NULL DEFAULT 0,
	PRIMARY KEY(MAKM)
)
GO
--TẠO BẢNG BAOCAOTONKHO
CREATE TABLE BAOCAOTON
(
	THANG INT NOT NULL CHECK(Thang >=1 and Thang <=12) DEFAULT MONTH(GETDATE()) ,
	NAM INT NOT NULL CHECK(NAM!=0) DEFAULT YEAR(GETDATE()),
	MASACH INT NOT NULL FOREIGN KEY REFERENCES SACH(MASACH),
	TONDAU INT NOT NULL DEFAULT 0,
	PHATSINH INT NOT NULL DEFAULT 0,
	TONCUOI INT NOT NULL DEFAULT 0,
	PRIMARY KEY( THANG,NAM,MASACH)
)
GO
--TẠO BẢNG BÁO CÁO DOANH THU
CREATE TABLE BAOCAODOANHTHU
(
	TUNGAY SMALLDATETIME,
	DENNGAY SMALLDATETIME,
	TONGTHU MONEY NOT NULL DEFAULT 0,
	TONGCHI MONEY NOT NULL DEFAULT 0,
	PRIMARY KEY(TUNGAY, DENNGAY)
)
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
	TENNHOM NVARCHAR(100) NOT NULL
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
	MANV INT,
	TENHIENTHI NVARCHAR(100),
	MATKHAU VARCHAR(100) NOT NULL DEFAULT '',
	MANHOM INT NOT NULL
)
GO
ALTER TABLE NGUOIDUNG ADD CONSTRAINT FK_NGUOIDUNG_NHANVIEN FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV)
GO
--TẠO BẢNG THAMSO
CREATE TABLE THAMSO
(
	SOLUONGTONTOIDA INT DEFAULT 0,
	SOLUONGTONTOITHIEU INT DEFAULT 0,
	TILETINHDONGIABAN FLOAT DEFAULT 0,
	SOLUONGNHAPTOIDA INT DEFAULT 0,
	SOLUONGNHAPTOITHIEU INT DEFAULT 0,
)
--TẠO KHÓA NGOẠI
ALTER TABLE SACH ADD CONSTRAINT FK_SACH_THELOAI  FOREIGN KEY(MATHELOAI) REFERENCES LOAISACH(MATHELOAI)
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
ALTER TABLE BAOCAOTON ADD CONSTRAINT FK_BAOCAOTON_SACH FOREIGN KEY(MASACH) REFERENCES SACH(MASACH)
GO
ALTER TABLE PHANQUYEN ADD CONSTRAINT FK_PHANQUYEN_NHOM FOREIGN KEY (MANHOM) REFERENCES NHOMNGUOIDUNG(MANHOM)
GO
ALTER TABLE PHANQUYEN ADD CONSTRAINT FK_PHANQUYEN_CHUCNANG FOREIGN KEY (MACHUCNANG) REFERENCES CHUCNANG(MACHUCNANG)
GO
ALTER TABLE NGUOIDUNG ADD CONSTRAINT FK_NGUOIDUNG_NHOM FOREIGN KEY(MANHOM) REFERENCES NHOMNGUOIDUNG(MANHOM)
GO
--Stored Procedure Xuất thông tin sách
CREATE PROC SP_LOADBOOK
AS
BEGIN
	SELECT MASACH, TENTHELOAI,TENSACH ,TACGIA, NHAXUATBAN, NAMXUATBAN, TOMTAT, GIANHAP, TONGSACHTON
	FROM SACH, LOAISACH
	WHERE SACH.MATHELOAI=LOAISACH.MATHELOAI
END
GO
--Stored Procedure Xuất tên thể loại sách
CREATE PROC SP_LOADBOOKCATEGOGY
AS
BEGIN
	SELECT MATHELOAI,TENTHELOAI
	FROM LOAISACH
END
GO
--Stored Procedure thêm sách
CREATE PROC SP_INSERTBOOK
@TENSACH NVARCHAR (100),@TACGIA NVARCHAR(100), @NHAXUATBAN NVARCHAR(100), @NAMXUATBAN INT, @TOMTAT NVARCHAR(200),@GIANHAP MONEY, @TONGSACHTON INT, @MATHELOAI INT
AS
BEGIN
	DECLARE @MASACH INT, @MASACH_MAX INT, @I INT
	SET @I=1
	--SET @GIANHAP MONEY=0
	SET @MASACH_MAX=(SELECT MAX(MASACH)
	FROM SACH)
	IF (@MASACH_MAX IS NULL)
		SET @MASACH=@I
	ELSE 
		BEGIN
		WHILE(@I<=@MASACH_MAX+1)
			BEGIN
				IF((SELECT COUNT(*)
					FROM SACH
					WHERE MASACH=@I)=0)
					BEGIN
						SET @MASACH=@I
						BREAK
					END
					SET @I=@I+1
			END
	END
	INSERT INTO SACH VALUES( @MASACH,@TENSACH,@TACGIA,@NHAXUATBAN,@NAMXUATBAN,@TOMTAT,@GIANHAP,@TONGSACHTON,@MATHELOAI)
END
GO
 --Store Procedure Update Sách
 CREATE PROC SP_UPDATEBOOK
 @MASACH INT,@TENSACH NVARCHAR (100),@TACGIA NVARCHAR(100), @NHAXUATBAN NVARCHAR(100), @NAMXUATBAN INT, @TOMTAT NVARCHAR(200),  @GIANHAP MONEY, @TONGSACHTON INT, @MATHELOAI INT
 AS
 BEGIN
	UPDATE SACH
	SET TENSACH=@TENSACH,TACGIA=@TACGIA, NHAXUATBAN=@NHAXUATBAN,NAMXUATBAN=@NAMXUATBAN,TOMTAT=@TOMTAT,GIANHAP=@GIANHAP,TONGSACHTON=@TONGSACHTON,MATHELOAI=@MATHELOAI
	WHERE MASACH=@MASACH
 END
 GO
 --Store Procedure Insert Loại sách
 CREATE PROC SP_INSERTBOOKCATEGOGY
 @TENTHELOAI NVARCHAR(100)
 AS 
 BEGIN
	DECLARE @MATHELOAI INT, @MATHELOAI_MAX INT, @I INT
	SET @I=1
	SELECT @MATHELOAI_MAX=MAX(MATHELOAI)
	FROM LOAISACH
	IF(@MATHELOAI_MAX IS NULL)
		BEGIN
			SET @MATHELOAI=@I
		END
	ELSE
		BEGIN
			WHILE(@I<=@MATHELOAI_MAX+1)
				BEGIN
					IF(SELECT COUNT(*)
						FROM LOAISACH
						WHERE MATHELOAI=@I)=0
						BEGIN
							SET @MATHELOAI=@I
							BREAK
						END
						SET @I=@I+1
				END
		END
	INSERT INTO LOAISACH VALUES(@MATHELOAI,@TENTHELOAI)
 END
 GO
 --Store Procedure cập nhật thể loại sách
 CREATE PROC SP_UPDATEBOOKCATEGOGY
 @MATHELOAI INT ,@TENTHELOAI NVARCHAR(100)
 AS 
 BEGIN
	UPDATE LOAISACH
	SET TENTHELOAI=@TENTHELOAI
	WHERE MATHELOAI=@MATHELOAI
 END
 GO
--Store Procedure load khuyến mãi
CREATE PROC SP_LOADDISCOUNT
AS
BEGIN
	SELECT * FROM KHUYENMAI
END
GO
--Store Procedure thêm khuyến mãi
CREATE PROC SP_INSERTDISCOUNT
@TENKM NVARCHAR(100), @HESOKM FLOAT, @MUCTIEN MONEY, @NGAYBD VARCHAR(19), @NGAYKT VARCHAR(19)
AS
BEGIN
	DECLARE @NGAYBD_ SMALLDATETIME, @NGAYKT_ SMALLDATETIME
	SET @NGAYBD_=CONVERT(smalldatetime,@NGAYBD,103)
	SET @NGAYKT_=CONVERT(smalldatetime,@NGAYKT,103)
	DECLARE @MAKM INT, @MAKM_MAX INT, @I INT
	SET @I=1
	SELECT @MAKM_MAX=MAX(MAKM)
	FROM KHUYENMAI
	IF(@MAKM_MAX IS NULL)
		set @MAKM=@I
	ELSE
		BEGIN
			WHILE(@I<=@MAKM_MAX+1)
				BEGIN
					IF(SELECT COUNT(*)
						FROM KHUYENMAI
						WHERE MAKM=@I)=0
						BEGIN
							SET @MAKM=@I
							BREAK
						END
						SET @I=@I+1
				END
	END
	INSERT INTO KHUYENMAI (MAKM,TENKM,MUCTIEN,NGAYBD,NGAYKT,HESOKM)
							VALUES (@MAKM,@TENKM,@MUCTIEN,@NGAYBD_,@NGAYKT_,@HESOKM)
END
GO
--STORE PROCEDURE CẬP NHẬT KHUYẾN MÃI
CREATE PROC SP_UPDATEDISCOUNT
@MAKM INT ,@TENKM NVARCHAR(100), @HESOKM FLOAT, @MUCTIEN MONEY, @NGAYBD VARCHAR(19), @NGAYKT VARCHAR(19)
AS
BEGIN
	DECLARE @NGAYBD_ SMALLDATETIME, @NGAYKT_ SMALLDATETIME
	SET @NGAYBD_=CONVERT(smalldatetime,@NGAYBD,103)
	SET @NGAYKT_=CONVERT(smalldatetime,@NGAYKT,103)
	UPDATE KHUYENMAI
	SET TENKM=@TENKM, HESOKM=@HESOKM,MUCTIEN=@MUCTIEN,NGAYBD=@NGAYBD_,NGAYKT=@NGAYKT_
	WHERE MAKM=@MAKM
END
GO
--STORE PROCEDURE XÓA KHUYẾN MÃI
CREATE PROC SP_DELETEDISCOUNT
@MAKM INT
AS
BEGIN
	DELETE FROM KHUYENMAI
	WHERE MAKM=@MAKM
END
GO

-- Hàm chuyển sang tiếng Việt k dấu để tìm gần đúng
CREATE FUNCTION [dbo].[GetUnsignString](@strInput NVARCHAR(4000)) 
RETURNS NVARCHAR(4000)
AS
BEGIN     
    IF @strInput IS NULL RETURN @strInput
    IF @strInput = '' RETURN @strInput
    DECLARE @RT NVARCHAR(4000)
    DECLARE @SIGN_CHARS NCHAR(136)
    DECLARE @UNSIGN_CHARS NCHAR (136)

    SET @SIGN_CHARS = N'ăâđêôơưàảãạáằẳẵặắầẩẫậấèẻẽẹéềểễệếìỉĩịíòỏõọóồổỗộốờởỡợớùủũụúừửữựứỳỷỹỵýĂÂĐÊÔƠƯÀẢÃẠÁẰẲẴẶẮẦẨẪẬẤÈẺẼẸÉỀỂỄỆẾÌỈĨỊÍÒỎÕỌÓỒỔỖỘỐỜỞỠỢỚÙỦŨỤÚỪỬỮỰỨỲỶỸỴÝ'+NCHAR(272)+ NCHAR(208)
    SET @UNSIGN_CHARS = N'aadeoouaaaaaaaaaaaaaaaeeeeeeeeeeiiiiiooooooooooooooouuuuuuuuuuyyyyyAADEOOUAAAAAAAAAAAAAAAEEEEEEEEEEIIIIIOOOOOOOOOOOOOOOUUUUUUUUUUYYYYYDD'

    DECLARE @COUNTER int
    DECLARE @COUNTER1 int
    SET @COUNTER = 1
 
    WHILE (@COUNTER <=LEN(@strInput))
    BEGIN   
      SET @COUNTER1 = 1
      --Tim trong chuoi mau
       WHILE (@COUNTER1 <=LEN(@SIGN_CHARS)+1)
       BEGIN
     IF UNICODE(SUBSTRING(@SIGN_CHARS, @COUNTER1,1)) = UNICODE(SUBSTRING(@strInput,@COUNTER ,1) )
     BEGIN           
          IF @COUNTER=1
              SET @strInput = SUBSTRING(@UNSIGN_CHARS, @COUNTER1,1) + SUBSTRING(@strInput, @COUNTER+1,LEN(@strInput)-1)                   
          ELSE
              SET @strInput = SUBSTRING(@strInput, 1, @COUNTER-1) +SUBSTRING(@UNSIGN_CHARS, @COUNTER1,1) + SUBSTRING(@strInput, @COUNTER+1,LEN(@strInput)- @COUNTER)    
              BREAK         
               END
             SET @COUNTER1 = @COUNTER1 +1
       END
      --Tim tiep
       SET @COUNTER = @COUNTER +1
    END
    RETURN @strInput
END
GO
--Store Tìm kiếm khách hàng theo tên
CREATE PROC SP_SEARCHCUSTOMER
@KEY NVARCHAR(100)
AS
BEGIN
	SELECT * FROM KHACHHANG WHERE [dbo].[GetUnsignString](TENKH) LIKE N'%' + [dbo].[GetUnsignString](@KEY) + '%'
END
GO
-- Store proc Xuất danh sách tất cả khách hàng
 CREATE PROC SP_LOADCUSTOMER
 AS
 BEGIN
	SELECT MAKH, TENKH , DIACHI, SODT, NGAYSINH, NGAYDKY, DOANHSO
	FROM KHACHHANG
	WHERE MAKH > 0
	ORDER BY MAKH DESC	
 END
 GO
-- Store proc Thêm khách hàng
CREATE PROC SP_INSERTCUSTOMER
@TENKH NVARCHAR(100), @DIACHI NVARCHAR(200), @SODT NVARCHAR(10), @NGAYSINH VARCHAR(19), @NGAYDKY VARCHAR(19)
AS
BEGIN
	DECLARE @MAKH_MAX INT, @I INT, @NGAYSINH_ SMALLDATETIME, @NGAYDKY_ SMALLDATETIME

	SET @NGAYSINH_ = CONVERT(SMALLDATETIME, @NGAYSINH, 103)
	SET @NGAYDKY_ = CONVERT(SMALLDATETIME, @NGAYDKY, 103)
	SET @I = 1

	SELECT @MAKH_MAX = MAX(MAKH)
	FROM KHACHHANG

	IF(@MAKH_MAX IS NULL)
	BEGIN
		INSERT INTO KHACHHANG VALUES(1, @TENKH, @DIACHI, @SODT, @NGAYSINH_, @NGAYDKY_, 0)
	END

	ELSE
	BEGIN
		WHILE(@I <= @MAKH_MAX + 1)
		BEGIN
			IF((SELECT COUNT(*) FROM KHACHHANG WHERE MAKH = @I) = 0)
			BEGIN
				INSERT INTO KHACHHANG VALUES(@I, @TENKH, @DIACHI, @SODT, @NGAYSINH_, @NGAYDKY_, 0)
				BREAK
			END
			SET @I += 1
		END
	END
END
GO
-- Store proc cập nhật khách hàng
CREATE PROC SP_UPDATECUSTOMER
@MAKH INT, @TENKH NVARCHAR(100), @DIACHI NVARCHAR(200), @SODT NVARCHAR(10), @NGAYSINH VARCHAR(19), @NGAYDKY VARCHAR(19)
AS
BEGIN
	DECLARE  @NGAYSINH_ SMALLDATETIME, @NGAYDKY_ SMALLDATETIME

	SET @NGAYSINH_ = CONVERT(SMALLDATETIME, @NGAYSINH, 103)
	SET @NGAYDKY_ = CONVERT(SMALLDATETIME, @NGAYDKY, 103)

	UPDATE KHACHHANG
	SET TENKH = @TENKH, DIACHI = @DIACHI, SODT = @SODT, NGAYSINH = @NGAYSINH_, NGAYDKY = @NGAYDKY_
	WHERE MAKH = @MAKH
END
GO
--STORE PROC TÌM SÁCH
CREATE PROC SP_SEARCHBOOK
@KEY NVARCHAR(100)
AS
BEGIN
	
	SELECT MASACH, TENTHELOAI,TENSACH, TACGIA, NHAXUATBAN, NAMXUATBAN, TOMTAT, GIANHAP, TONGSACHTON
	FROM SACH, LOAISACH
	WHERE SACH.MATHELOAI=LOAISACH.MATHELOAI AND [dbo].[GetUnsignString](TENSACH) LIKE N'%' + [dbo].[GetUnsignString](@KEY) + '%'
END
GO
--STORE PROC TÌM THỂ LOẠI SÁCH
CREATE PROC SP_SEARCHBOOKCATEGOGY
@KEY NVARCHAR(100)
AS
BEGIN
	SELECT * FROM LOAISACH WHERE [dbo].[GetUnsignString](TENTHELOAI) LIKE N'%' + [dbo].[GetUnsignString](@KEY) + '%'
END
GO
--STORE PROC TÌM KHUYẾN MÃI
CREATE PROC SP_SEARCHDISCOUNT
@KEY NVARCHAR(100)
AS
BEGIN
	SELECT * FROM KHUYENMAI WHERE [dbo].[GetUnsignString](TENKM) LIKE N'%' + [dbo].[GetUnsignString](@KEY) + '%'
END
GO
--STORE PROC LOAD CÔNG TY
CREATE PROC SP_LOAD_DISTRIBUTOR
AS
BEGIN
	SELECT * FROM CONGTY
END
GO
--STORE PROC INSERT CÔNG TY
CREATE PROC SP_INSERTDISTRIBUTOR
@TENCTY NVARCHAR(100), @DIACHI NVARCHAR(100), @SODT NVARCHAR(10)
AS
BEGIN
	DECLARE @MACTY INT, @MACTY_MAX INT, @I INT
	SET @I=1
	SET @MACTY_MAX=(SELECT MAX(MACTY)
					FROM CONGTY)
	IF(@MACTY_MAX IS NULL)
		INSERT INTO CONGTY VALUES(@I,@TENCTY,@DIACHI,@SODT)
	ELSE
		BEGIN
			WHILE(@I<=@MACTY_MAX+1)
				BEGIN
					IF(SELECT COUNT(*)
						FROM CONGTY
						WHERE MACTY=@I) =0
						BEGIN
							SET @MACTY=@I
							INSERT INTO CONGTY VALUES(@MACTY,@TENCTY,@DIACHI,@SODT)
							BREAK
						END
					SET @I=@I+1
				END
		END
END
GO
--STORE PROC UPDATE CONGTY
CREATE PROC SP_UPDATEDISTRIBUTOR
@MACTY INT,@TENCTY NVARCHAR(100), @DIACHI NVARCHAR(100), @SODT NVARCHAR(10)
AS
BEGIN
	UPDATE CONGTY
	SET TENCTY=@TENCTY, DIACHI=@DIACHI,SODT=@SODT
	WHERE MACTY=@MACTY
END
GO
--SOTRE PROC TÌM CONGTY
CREATE PROC SP_SEARCHDISTRIBUTOR
@KEY NVARCHAR(100)
AS 
BEGIN
	SELECT * FROM CONGTY WHERE [dbo].[GetUnsignString](TENCTY) LIKE N'%' + [dbo].[GetUnsignString](@KEY) + '%'
END
GO

--STORE PROC LẤY DANH SÁCH PHIẾU NHẬP
CREATE PROC SP_LOADBOOKSTOCK
AS
BEGIN
	SELECT SOPHIEUNHAP, NGAYNHAP, TENCTY,TONGTIEN
	FROM PHIEUNHAP, CONGTY
	WHERE PHIEUNHAP.MACTY=CONGTY.MACTY
END
GO
--STORE PROC LẤY DANH SÁCH CHI TIẾT PHIẾU NHẬP
CREATE PROC SP_LOADBOOKSTOCKDETAIL
AS
BEGIN
	SELECT SOPHIEUNHAP, TENSACH , SOLUONGNHAP,CT_PHIEUNHAP.GIANHAP, THANHTIEN
	FROM CT_PHIEUNHAP,SACH
	WHERE CT_PHIEUNHAP.MASACH=SACH.MASACH
END
GO
--STORE PROC THÊM PHIẾU NHẬP
CREATE PROC SP_INSERTBOOKSTOCK
@NGAYNHAP NVARCHAR(19), @MACTY INT
AS
BEGIN
	DECLARE @NGAYNHAP_ SMALLDATETIME
	SET @NGAYNHAP_=CONVERT(smalldatetime,@NGAYNHAP,103)
	DECLARE @SOPHIEUNHAP INT, @SOPHIEUNHAP_MAX INT, @I INT
	SET @I=1
	SET @SOPHIEUNHAP_MAX=(SELECT MAX(SOPHIEUNHAP)
							FROM PHIEUNHAP)
	IF(@SOPHIEUNHAP_MAX IS NULL)
		SET @SOPHIEUNHAP=@I
	ELSE
		BEGIN
			WHILE(@I<=@SOPHIEUNHAP_MAX+1)
				BEGIN
					IF(SELECT COUNT(*)
						FROM PHIEUNHAP
						WHERE SOPHIEUNHAP=@I)=0
						BEGIN
							SET @SOPHIEUNHAP=@I
							BREAK
						END
					 SET @I=@I+1
				END
		END
	INSERT INTO PHIEUNHAP VALUES(@SOPHIEUNHAP,@NGAYNHAP_,@MACTY,0)
END
GO
--STORE PROC CẬP NHẬT PHIẾU NHẬP SÁCH
CREATE PROC SP_UPDATEBOOKSTOCK
@SOPHIEUNHAP INT, @NGAYNHAP NVARCHAR(19),@MACTY INT
AS
BEGIN
	DECLARE @NGAYNHAP_ SMALLDATETIME
	SET @NGAYNHAP_=CONVERT(smalldatetime,@NGAYNHAP,103)
	UPDATE PHIEUNHAP
	SET NGAYNHAP=@NGAYNHAP_,MACTY=@MACTY
	WHERE SOPHIEUNHAP=@SOPHIEUNHAP
END
GO
--STORE PROC XÓA PHIẾU NHẬP SÁCH
CREATE PROC SP_DELETEBOOKSTOCK
@SOPHIEUNHAP INT
AS
BEGIN
	IF(SELECT COUNT(*)
		FROM CT_PHIEUNHAP
		WHERE SOPHIEUNHAP=@SOPHIEUNHAP)=0
		BEGIN
			DELETE FROM PHIEUNHAP
			WHERE SOPHIEUNHAP=@SOPHIEUNHAP
		END
	ELSE
		ROLLBACK TRAN
END
GO
--STORE PROC TÌM PHIẾU NHẬP SÁCH THEO NHÀ CUNG CẤP
CREATE PROC SP_SEARCHBOOKSTOCK
@KEY NVARCHAR(100)
AS
BEGIN
	SELECT SOPHIEUNHAP, NGAYNHAP,TENCTY,TONGTIEN
	FROM PHIEUNHAP,CONGTY
    WHERE PHIEUNHAP.MACTY=CONGTY.MACTY AND [dbo].[GetUnsignString](TENCTY) LIKE N'%' + [dbo].[GetUnsignString](@KEY) + '%'
END
GO
--STORE PROC THÊM CHI TIẾT PHIẾU NHẬP SÁCH
CREATE PROC SP_INSERTBOOKSTOCKDETAIL
@SOPHIEUNHAP INT,@MASACH INT, @SOLUONGNHAP INT,@GIANHAP MONEY
AS
BEGIN
	DECLARE @THANHTIEN MONEY
	SET @THANHTIEN=@SOLUONGNHAP*@GIANHAP
	INSERT INTO CT_PHIEUNHAP VALUES(@SOPHIEUNHAP,@MASACH,@SOLUONGNHAP,@GIANHAP,@THANHTIEN)
END
GO
--STRORE PROC SỬA CHI TIẾT PHIẾU NHẬP SÁCH
CREATE PROC SP_UPDATEBOOKSTOCKDETAIL
@SOPHIEUNHAP INT, @MASACH INT, @SOLUONGNHAP INT,@GIANHAP MONEY
AS
BEGIN
	UPDATE CT_PHIEUNHAP
	SET SOLUONGNHAP=@SOLUONGNHAP,GIANHAP=@GIANHAP,THANHTIEN=@SOLUONGNHAP*@GIANHAP
	WHERE SOPHIEUNHAP=@SOPHIEUNHAP AND MASACH=@MASACH
	
END
GO
--STORE PROC XÓA CHI TIẾT PHIẾU NHẬP SÁCH
CREATE PROC SP_DELETEBOOKSTOCKDETAIL
@SOPHIEUNHAP INT,@MASACH INT
AS
BEGIN	
	DELETE FROM CT_PHIEUNHAP
	WHERE SOPHIEUNHAP=@SOPHIEUNHAP AND MASACH=@MASACH
END
GO
--STORE TÌM CHI TIẾT PHIẾU NHẬP SÁCH THEO SỐ PHIẾU NHẬP
CREATE PROC SP_SEARCHBOOKSTOCKDETAIL
@SOPHIEUNHAP INT
AS
BEGIN
	SELECT SOPHIEUNHAP, TENSACH , SOLUONGNHAP,CT_PHIEUNHAP.GIANHAP, THANHTIEN
	FROM CT_PHIEUNHAP,SACH
	WHERE CT_PHIEUNHAP.MASACH=SACH.MASACH AND SOPHIEUNHAP=@SOPHIEUNHAP
END
GO
--TRIGGER KIỂM KHI INSERT, UPDATE BẢNG CT_PHIEUNHAP
CREATE TRIGGER TRG_ISN_UP_CT_PHIEUNHAP ON CT_PHIEUNHAP
FOR INSERT,UPDATE
AS
BEGIN
	DECLARE @SOPHIEUNHAP INT,@MASACH INT, @SOLUONGNHAP INT,@GIANHAP MONEY,@THANHTIEN MONEY
	SELECT @SOPHIEUNHAP=SOPHIEUNHAP,@MASACH=MASACH,@SOLUONGNHAP=SOLUONGNHAP,@GIANHAP=GIANHAP,@THANHTIEN=@THANHTIEN
	FROM inserted
	DECLARE @TONGTIEN MONEY, @TONGSACHTON INT,@TONGSACHNHAP INT,@TONGSACHBAN INT
	--CẬP NHẬT LẠI TỔNG TIỀN Ở BẢNG PHIẾU NHẬP
	SET @TONGTIEN=(SELECT SUM(THANHTIEN)
					FROM CT_PHIEUNHAP
					WHERE SOPHIEUNHAP=@SOPHIEUNHAP)
	UPDATE PHIEUNHAP
	SET TONGTIEN=@TONGTIEN
	WHERE SOPHIEUNHAP=@SOPHIEUNHAP
	--CẬP NHẬT LẠI TỔNG SÁCH TỒN Ở BẢNG SÁCH
	SET @TONGSACHNHAP=(SELECT SUM(SOLUONGNHAP)
						FROM CT_PHIEUNHAP
						WHERE MASACH=@MASACH)
	IF(@TONGSACHNHAP IS NULL) SET @TONGSACHNHAP=0
	SET @TONGSACHBAN=(SELECT SUM(SOLUONG)
						FROM CTHD
						WHERE MASACH=@MASACH)
	IF(@TONGSACHBAN IS NULL) SET @TONGSACHBAN=0
	SET @TONGSACHTON=@TONGSACHNHAP-@TONGSACHBAN
	UPDATE SACH
	SET TONGSACHTON=@TONGSACHTON,GIANHAP=@GIANHAP
	WHERE MASACH=@MASACH
END
GO
--TRIGGER XÓA CHI TIẾT PHIẾU NHẬP
CREATE TRIGGER TRG_DEL_CT_PHIEUNHAP ON CT_PHIEUNHAP
FOR DELETE
AS
BEGIN
	DECLARE @SOPHIEUNHAP INT,@MASACH INT, @SOLUONGNHAP INT,@THANHTIEN MONEY
	SELECT @SOPHIEUNHAP=SOPHIEUNHAP,@MASACH=MASACH,@SOLUONGNHAP=SOLUONGNHAP,@THANHTIEN=THANHTIEN
	FROM deleted
	DECLARE @TONGTIEN MONEY, @TONGSACHTON INT,@TONGSACHNHAP INT,@TONGSACHBAN INT
	--CẬP NHẬT LẠI TỔNG TIỀN Ở BẢNG PHIẾU NHẬP
	SET @TONGTIEN=(SELECT SUM(THANHTIEN)
					FROM CT_PHIEUNHAP
					WHERE SOPHIEUNHAP=@SOPHIEUNHAP)
	UPDATE PHIEUNHAP
	SET TONGTIEN=@TONGTIEN
	WHERE SOPHIEUNHAP=@SOPHIEUNHAP
	--CẬP NHẬT LẠI TỔNG SÁCH TỒN Ở BẢNG SÁCH
	SET @TONGSACHNHAP=(SELECT SUM(SOLUONGNHAP)
						FROM CT_PHIEUNHAP
						WHERE MASACH=@MASACH)
	SET @TONGSACHBAN=(SELECT SUM(SOLUONG)
						FROM CTHD
						WHERE MASACH=@MASACH)
	SET @TONGSACHTON=@TONGSACHNHAP-@TONGSACHBAN
	UPDATE SACH
	SET TONGSACHTON=@TONGSACHTON
	WHERE MASACH=@MASACH
	
END
--STORE PROC THÊM NHÂN VIÊN
CREATE PROC SP_INSERTSTAFF
@TENNV NVARCHAR(100), @NGAYSINH NVARCHAR(19), @GIOITINH NVARCHAR(100), @DIACHI NVARCHAR(100), @SODT NVARCHAR(10), @NGAYVL NVARCHAR(19),@TRANGTHAI INT
AS
BEGIN
	DECLARE @MANV INT,@I INT,@MANV_MAX INT
	SET @I =1
	SELECT @MANV_MAX=(SELECT MAX(MANV)
						FROM NHANVIEN)
	IF(@MANV_MAX IS NULL)
		SET @MANV=@I
	ELSE
		BEGIN
			WHILE(@I<=@MANV_MAX+1)
				BEGIN
					IF(SELECT COUNT(*)
						FROM NHANVIEN
						WHERE MANV=@I)=0
						BEGIN
							SET @MANV=@I
							BREAK
						END
					SET @I=@I+1
				END
	END
	DECLARE @NGAYSINH_ SMALLDATETIME,@NGAYVL_ SMALLDATETIME
	SET @NGAYSINH_=CONVERT(smalldatetime,@NGAYSINH,103)
	SET @NGAYVL_=CONVERT(smalldatetime,@NGAYVL,103)
	INSERT INTO NHANVIEN VALUES(@MANV,@TENNV,@NGAYSINH_,@GIOITINH,@DIACHI,@SODT,@NGAYVL_,@TRANGTHAI)
END
GO
--STORE PROC CẬP NHẬT NHÂN VIÊN
CREATE PROC SP_UPDATESTAFF
@MANV INT,@TENNV NVARCHAR(100), @NGAYSINH NVARCHAR(19), @GIOITINH NVARCHAR(100), @DIACHI NVARCHAR(100), @SODT NVARCHAR(10), @NGAYVL NVARCHAR(19),@TRANGTHAI INT
AS
BEGIN
	DECLARE @NGAYSINH_ SMALLDATETIME,@NGAYVL_ SMALLDATETIME
	SET @NGAYSINH_=CONVERT(smalldatetime,@NGAYSINH,103)
	SET @NGAYVL_=CONVERT(smalldatetime,@NGAYVL,103)
	UPDATE NHANVIEN
	SET TENNV=@TENNV,NGAYSINH=@NGAYSINH_,GIOITINH=@GIOITINH,DIACHI=@DIACHI,SODT=@SODT,NGAYVL=@NGAYVL_,TRANGTHAI=@TRANGTHAI
	WHERE MANV=@MANV
END
GO
--STORE TÌM NHÂN VIÊN
CREATE PROC SP_SEARCHSTAFF
@KEY NVARCHAR(100)
AS
BEGIN
	SELECT *
	FROM NHANVIEN
    WHERE [dbo].[GetUnsignString](TENNV) LIKE N'%' + [dbo].[GetUnsignString](@KEY) + '%'
END
GO
--LẤY DANH SÁCH NHÂN VIÊN HIỆN LÀM VIỆC Ở CỬA HÀNG
CREATE PROC SP_LOADSTAFFNOW
AS
BEGIN
	SELECT * FROM NHANVIEN
	WHERE TRANGTHAI='1'
END

--LẤY THÔNG TIN HÓA ĐƠN
GO
ALTER PROC SP_LOADBILL
AS
BEGIN
	SELECT SOHD, NGAYHD, HOADON.MAKH, TENKH, HOADON.MANV, TENNV, VAT, HESOKM, TRIGIA, TONGTIEN
	FROM HOADON, KHACHHANG, NHANVIEN
	WHERE HOADON.MAKH = KHACHHANG.MAKH AND HOADON.MANV = NHANVIEN.MANV
	ORDER BY SOHD DESC
END
GO

EXEC SP_LOADBILL
SELECT * FROM HOADON
-- THÊM HÓA ĐƠN
GO
ALTER PROC SP_INSERTBILL
@NGAYHD VARCHAR(19), @MAKH INT, @MANV INT
AS
BEGIN
	DECLARE @SOHD_MAX INT, @I INT, @NGAYHD_ SMALLDATETIME, @VAT FLOAT

	SELECT @SOHD_MAX = MAX(SOHD)
	FROM HOADON

	SELECT @VAT = VAT
	FROM THAMSO

	SET @I = 1
	SET @NGAYHD_ = CONVERT(SMALLDATETIME, @NGAYHD, 103)
	
	IF(@SOHD_MAX IS NULL)
	BEGIN
		INSERT INTO HOADON VALUES(1, @NGAYHD_, @MAKH, @MANV, @VAT, 0, 0, 0)
	END
	ELSE
	BEGIN
		WHILE(@I <= @SOHD_MAX + 1)
		BEGIN
			IF((SELECT COUNT(*) FROM HOADON WHERE SOHD = @I) < 1)
			BEGIN
				INSERT INTO HOADON VALUES(@I, @NGAYHD_, @MAKH, @MANV, @VAT, 0, 0, 0)
				BREAK
			END
			SET @I += 1
		END
	END	
END
GO

EXEC SP_INSERTBILL '17-11-2018', 0, 1

SELECT * FROM HOADON

-- CẬP NHẬT HÓA ĐƠN
GO
ALTER PROC SP_UPDATEBILL
@SOHD INT, @NGAYHD VARCHAR(19), @MAKH INT, @MANV INT
AS
BEGIN
	DECLARE @NGAYHD_ SMALLDATETIME

	SET @NGAYHD_ = CONVERT(SMALLDATETIME, @NGAYHD, 103)

	UPDATE HOADON
	SET NGAYHD = @NGAYHD_, MAKH = @MAKH
	WHERE SOHD = @SOHD
END
GO

-- XÓA HÓA ĐƠN
GO
CREATE PROC SP_DELETEBILL
@SOHD INT
AS
BEGIN
	DELETE FROM HOADON
	WHERE SOHD = @SOHD
END
-- TÌM HÓA ĐƠN THEO NGÀY
GO
ALTER PROC SP_SEARCHBILL
@NGAYHD VARCHAR(19)
AS
BEGIN
	DECLARE @NGAYHD_ SMALLDATETIME

	SET @NGAYHD_ = CONVERT(SMALLDATETIME, @NGAYHD, 103)

	IF(@NGAYHD = '')
		SELECT SOHD, NGAYHD, HOADON.MAKH, TENKH, HOADON.MANV, TENNV, VAT, HESOKM, TRIGIA, TONGTIEN
		FROM HOADON, KHACHHANG, NHANVIEN
		WHERE HOADON.MAKH = KHACHHANG.MAKH AND HOADON.MANV = NHANVIEN.MANV
	ELSE
		SELECT SOHD, NGAYHD, HOADON.MAKH, TENKH, HOADON.MANV, TENNV, VAT, HESOKM, TRIGIA, TONGTIEN
		FROM HOADON, KHACHHANG, NHANVIEN
		WHERE HOADON.MAKH = KHACHHANG.MAKH AND HOADON.MANV = NHANVIEN.MANV AND NGAYHD = @NGAYHD_
END

--LẤY TÊN NHÂN VIÊN ỨNG VỚI SỐ HÓA ĐƠN
GO
CREATE PROC SP_GETNAMESTAFFBYIDBILL
@SOHD INT
AS
BEGIN
	SELECT TENNV 
	FROM NHANVIEN, HOADON
	WHERE NHANVIEN.MANV = HOADON.MANV AND SOHD = @SOHD
END

EXEC SP_GETNAMESTAFFBYIDBILL 1

--TRIGER KHI THÊM , CẬP NHẬT CTHD
GO
alter TRIGGER TRG_INSUP_CTTT ON CTHD
FOR INSERT, UPDATE
AS
BEGIN
	DECLARE @SOHD INT, @MASACH INT, @SOLUONG INT, @TONGSACHTON INT, @TRIGIA MONEY, @HESOKM FLOAT, @MAKM INT, @MAKH INT, @DOANHSO FLOAT, @SOLUONGBO INT, @SOHDBO INT, @MASACHBO INT, @GIABAN MONEY

	SELECT @SOHD = inserted.SOHD, @MASACH = inserted.MASACH, @SOLUONG = SOLUONG, @TONGSACHTON = TONGSACHTON, @MAKH = MAKH
	FROM inserted, SACH, HOADON
	WHERE inserted.MASACH = SACH.MASACH AND inserted.SOHD = HOADON.SOHD

	SELECT @SOLUONGBO = SOLUONG, @MASACHBO = MASACH, @SOHDBO = SOHD
	FROM deleted

	--Tính giá bán CTHD
	SELECT @GIABAN = GIANHAP*TILETINHDONGIABAN
	FROM SACH, THAMSO
	WHERE MASACH = @MASACH

	UPDATE CTHD
	SET GIABAN = @GIABAN
	WHERE SOHD = @SOHD AND MASACH = @MASACH

	--Tính thành tiền CTHD
	UPDATE CTHD
	SET THANHTIEN = GIABAN * @SOLUONG
	WHERE SOHD = @SOHD AND MASACH = @MASACH

	--Cập nhật SL sách tồn trong bảng Sách
	IF(@MASACH = @MASACHBO AND @SOHD = @SOHDBO)
	UPDATE SACH
	SET TONGSACHTON = @TONGSACHTON + @SOLUONGBO - @SOLUONG
	WHERE MASACH = @MASACH
	ELSE
	UPDATE SACH
	SET TONGSACHTON = @TONGSACHTON - @SOLUONG
	WHERE MASACH = @MASACH

	--Tính Trị giá hóa đơn
	SET @TRIGIA = (SELECT SUM(THANHTIEN)
					FROM CTHD
					WHERE SOHD = @SOHD)
	UPDATE HOADON
	SET TRIGIA = @TRIGIA
	WHERE SOHD = @SOHD
	-- Tính tổng tiền hóa đơn
	SET @MAKM = (SELECT DISTINCT MAKM
				FROM KHUYENMAI
				WHERE @TRIGIA >= MUCTIEN AND NGAYBD <= GETDATE() AND GETDATE() <= NGAYKT
				GROUP BY MAKM, MUCTIEN
				HAVING MUCTIEN >= ALL(SELECT MUCTIEN
									FROM KHUYENMAI
									WHERE @TRIGIA >= MUCTIEN AND NGAYBD <= GETDATE() AND GETDATE() <= NGAYKT
									GROUP BY MAKM, MUCTIEN))

	SELECT @HESOKM = HESOKM
	FROM KHUYENMAI
	WHERE MAKM = @MAKM

	IF @HESOKM IS NULL SET @HESOKM = 0

	UPDATE HOADON
	SET TONGTIEN = TRIGIA * (1 - @HESOKM + VAT), HESOKM = @HESOKM
	WHERE SOHD = @SOHD
	-- Cập nhật doanh số của khách hàng
	SET @DOANHSO = (SELECT SUM(TONGTIEN)
					FROM HOADON
					WHERE MAKH = @MAKH AND MAKH > 0) 
	UPDATE KHACHHANG
	SET DOANHSO = @DOANHSO
	WHERE MAKH = @MAKH AND MAKH > 0

END


--TRIGGER KHI XÓA CTHD
GO
ALTER TRIGGER TRG_DEL_CTTT ON CTHD
FOR DELETE
AS
BEGIN
DECLARE @SOHD INT, @MASACH INT, @SOLUONG INT, @TONGSACHTON INT, @TRIGIA MONEY, @HESOKM FLOAT, @MAKM INT, @THANHTIEN MONEY, @MAKH INT, @DOANHSO FLOAT, @GIABAN MONEY

	SELECT @SOHD = deleted.SOHD, @MASACH = deleted.MASACH, @SOLUONG = SOLUONG, @TONGSACHTON = TONGSACHTON, @MAKH = MAKH
	FROM deleted, SACH, HOADON
	WHERE deleted.MASACH = SACH.MASACH AND deleted.SOHD = HOADON.SOHD

	--Tính giá bán CTHD vừa xóa
	SELECT @GIABAN = GIANHAP*TILETINHDONGIABAN
	FROM SACH, THAMSO
	WHERE MASACH = @MASACH

	--Tính thành tiền CTHD vừa xóa	
	SELECT  @THANHTIEN = @GIABAN * @SOLUONG
	FROM deleted

	--Cập nhật SL sách tồn trong bảng Sách
	UPDATE SACH
	SET TONGSACHTON = @TONGSACHTON + @SOLUONG
	WHERE MASACH = @MASACH

	--Tính Trị giá hóa đơn

	UPDATE HOADON
	SET TRIGIA = TRIGIA - @THANHTIEN
	WHERE SOHD = @SOHD

	SET @TRIGIA = (SELECT TRIGIA FROM HOADON WHERE SOHD = @SOHD)
	-- Tính tổng tiền hóa đơn
	SET @MAKM = (SELECT DISTINCT MAKM
				FROM KHUYENMAI
				WHERE @TRIGIA >= MUCTIEN AND NGAYBD <= GETDATE() AND GETDATE() <= NGAYKT
				GROUP BY MAKM, MUCTIEN
				HAVING MUCTIEN >= ALL(SELECT MUCTIEN
									FROM KHUYENMAI
									WHERE @TRIGIA >= MUCTIEN AND NGAYBD <= GETDATE() AND GETDATE() <= NGAYKT
									GROUP BY MAKM, MUCTIEN))

	SELECT @HESOKM = HESOKM
	FROM KHUYENMAI
	WHERE MAKM = @MAKM

	IF @HESOKM IS NULL SET @HESOKM = 0

	UPDATE HOADON
	SET TONGTIEN = TRIGIA * (1 - @HESOKM + VAT), HESOKM = @HESOKM
	WHERE SOHD = @SOHD
	-- Cập nhật doanh số của khách hàng
	SET @DOANHSO = (SELECT SUM(TONGTIEN)
					FROM HOADON
					WHERE MAKH = @MAKH AND MAKH > 0) 
	UPDATE KHACHHANG
	SET DOANHSO = @DOANHSO
	WHERE MAKH = @MAKH AND MAKH > 0
END
GO


SELECT * FROM HOADON
SELECT * FROM CTHD
SELECT * FROM SACH
SELECT * FROM KHACHHANG



--LẤY THÔNG TIN CTHD
ALTER PROC SP_LOADBILLINFO
@SOHD INT
AS
BEGIN
	IF(@SOHD > 0)
		SELECT SOHD, CTHD.MASACH, TENSACH, GIABAN, SOLUONG, THANHTIEN
		FROM CTHD, SACH
		WHERE CTHD.MASACH = SACH.MASACH AND CTHD.SOHD = @SOHD
		ORDER BY CTHD.SOHD DESC
	ELSE
		SELECT SOHD, CTHD.MASACH, TENSACH, GIABAN, SOLUONG, THANHTIEN
		FROM CTHD, SACH
		WHERE CTHD.MASACH = SACH.MASACH
END
GO
delete from CTHD
select * from CTHD
exec  SP_LOADBILLINFO 0
--THÊM CTHD
ALTER PROC SP_INSERTBILLINFO
@SOHD INT, @MASACH INT, @SOLUONG INT
AS
BEGIN
	INSERT INTO CTHD VALUES(@SOHD, @MASACH, @SOLUONG, 0, 0)
END
GO
--CẬP NHẬT CTHD
CREATE PROC SP_UPDATEBILLINFO
@SOHD INT, @MASACH INT, @SOLUONG INT
AS
BEGIN
	UPDATE CTHD
	SET SOLUONG = @SOLUONG
	WHERE SOHD = @SOHD AND MASACH = @MASACH 
END
GO
--XÓA CTHD
CREATE PROC SP_DELETEBILLINFO
@SOHD INT, @MASACH INT
AS
BEGIN
	DELETE FROM CTHD
	WHERE SOHD = @SOHD AND MASACH = @MASACH
END
GO

exec SP_DELETEBILLINFO 1, 2
--TÌM CTHD THEO NGÀY
ALTER PROC SP_SEARCHBILLINFO
@NGAYHD VARCHAR(19)
AS
BEGIN
	DECLARE @NGAYHD_ SMALLDATETIME

	SET @NGAYHD_ = CONVERT(SMALLDATETIME, @NGAYHD, 103)

	IF(@NGAYHD = '')
		SELECT CTHD.SOHD, CTHD.MASACH, TENSACH, SOLUONG, GIABAN, THANHTIEN  
		FROM CTHD, SACH
		WHERE CTHD.MASACH = SACH.MASACH
	ELSE
		SELECT CTHD.SOHD, CTHD.MASACH, TENSACH, SOLUONG, GIABAN, THANHTIEN 
		FROM HOADON, CTHD, SACH
		WHERE HOADON.SOHD = CTHD.SOHD AND CTHD.MASACH = SACH.MASACH AND NGAYHD = @NGAYHD_
END
--CẬP NHẬT QUY ĐỊNH
CREATE PROC SP_UPDATERULE
@SLTONTOIDA INT, @SLTONTOITHIEU INT, @TILETINHDONGIABAN FLOAT, @SLNHAPTOIDA INT, @SLNHAPTOITHIEU INT, @VAT FLOAT
AS
BEGIN
	UPDATE THAMSO
	SET SOLUONGTONTOIDA = @SLTONTOIDA, SOLUONGTONTOITHIEU = @SLTONTOITHIEU, TILETINHDONGIABAN = @TILETINHDONGIABAN, SOLUONGNHAPTOIDA = @SLNHAPTOIDA, SOLUONGNHAPTOITHIEU = @SLNHAPTOITHIEU, VAT = @VAT
END
go
--LẤY THÔNG TIN QUY ĐỊNH
CREATE PROC SP_LOADRULE
AS
BEGIN
	SELECT * FROM THAMSO
END
--THÊM DỮ LIỆU VÀO BẢNG CHUCNANG
INSERT CHUCNANG VALUES (1,N'Quản lý khách hàng',N'Quản lý khách hàng')
GO
INSERT CHUCNANG VALUES (2,N'Quản lý khuyến mãi',N'Quản lý khuyến mãi')
GO
INSERT CHUCNANG VALUES (3,N'Quản lý sách',N'Quản lý sách')
GO
INSERT CHUCNANG VALUES (4,N'Báo cáo tồn kho',N'Báo cáo tồn kho')
GO
INSERT CHUCNANG VALUES (5,N'Báo cáo doanh thu',N'Báo cáo doanh thu')
GO
INSERT CHUCNANG VALUES (6,N'Quản lý quy định',N'Quản lý quy định')
GO
INSERT CHUCNANG VALUES (7,N'Quản lý bán hàng hàng',N'Quản lý bán hàng')
GO
INSERT CHUCNANG VALUES (8,N'Quản lý nhân viên',N'Quản lý nhân viên')
GO
INSERT CHUCNANG VALUES (9,N'Quản lý nhập sách',N'Quản lý nhập sách')
GO
INSERT CHUCNANG VALUES (10,N'Tra cứu sách',N'Tra cứu sách')
GO
INSERT CHUCNANG VALUES (11,N'Tra cứu khuyến mãi',N'Tra cứu khuyến mãi')
GO
--THÊM DỮ LIỆU BẢNG NHOMNGUOIDUNG
INSERT NHOMNGUOIDUNG VALUES (1,N'Nhân viên quản lý')
GO
INSERT NHOMNGUOIDUNG VALUES (2,N'Nhân viên bán hàng')
GO
--THÊM DỮ LIỆU VÀO BẢNG PHANQUYEN
INSERT INTO PHANQUYEN VALUES (1,2)
GO
INSERT INTO PHANQUYEN VALUES (1,3)
GO
INSERT INTO PHANQUYEN VALUES (1,4)
GO
INSERT INTO PHANQUYEN VALUES (1,5)
GO
INSERT INTO PHANQUYEN VALUES (1,6)
GO
INSERT INTO PHANQUYEN VALUES (1,7)
GO
INSERT INTO PHANQUYEN VALUES (1,8)
GO
INSERT INTO PHANQUYEN VALUES (1,9)
GO
INSERT INTO PHANQUYEN VALUES (1,10)
GO
INSERT INTO PHANQUYEN VALUES (1,11)
GO
INSERT INTO PHANQUYEN VALUES (2,1)
GO
INSERT INTO PHANQUYEN VALUES (2,5)
GO
INSERT INTO PHANQUYEN VALUES (2,7)
GO
INSERT INTO PHANQUYEN VALUES (2,10)
GO
--HIỆN THỊ DANH SÁCH NGƯỜI DÙNG
CREATE PROC SP_LOADUSER
AS
BEGIN
	SELECT TENNHOM, TENNV, TENDANGNHAP, TENHIENTHI,MATKHAU
	FROM NGUOIDUNG, NHANVIEN, NHOMNGUOIDUNG
	WHERE NGUOIDUNG.MANHOM=NHOMNGUOIDUNG.MANHOM AND NHANVIEN.MANV =NGUOIDUNG.MANV
END
GO
--THÊM NGƯỜI DÙNG
--CẬP NHẬT NGƯỜI DÙNG
--XÓA NGƯỜI DÙNG
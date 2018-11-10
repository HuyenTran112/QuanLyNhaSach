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
	GIOITINH NVARCHAR(100),
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
	MUCTIEN MONEY,
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
--Stored Procedure thêm sách
SELECT * FROM SACH
GO
CREATE PROC SP_INSERTBOOK
@TENSACH NVARCHAR (100), @NHAXUATBAN NVARCHAR(100), @NAMXUATBAN INT, @TOMTAT NVARCHAR(200), @GIABAN MONEY, @GIANHAP MONEY, @TONGSACHTON INT, @MATHELOAI INT
AS
BEGIN
	DECLARE @MASACH INT, @MASACH_MAX INT, @I INT
	SET @I=1
	SET @MASACH_MAX=(SELECT MAX(MASACH)
	FROM SACH)
	IF (@MASACH_MAX IS NULL)
		BEGIN
			INSERT INTO SACH VALUES( @I,@TENSACH, @NHAXUATBAN,@NAMXUATBAN,@TOMTAT,@GIABAN,@GIANHAP,@TONGSACHTON,@MATHELOAI)
		END
	ELSE 
		BEGIN
		WHILE(@I<=@MASACH_MAX+1)
			BEGIN
				IF((SELECT COUNT(*)
					FROM SACH
					WHERE MASACH=@I)=0)
					BEGIN
						INSERT INTO SACH VALUES( @I,@TENSACH, @NHAXUATBAN,@NAMXUATBAN,@TOMTAT,@GIABAN,@GIANHAP,@TONGSACHTON,@MATHELOAI)
					END
					SET @I=@I+1
			END
	END
END
GO
EXEC SP_INSERTBOOK N'Hệ quản trị cơ sỡ dữ liệu',N'Đại học quốc gia',2017,'',100000,80000,10,7
GO
SELECT * FROM LOAISACH
GO
SELECT * FROM SACH
GO

 --Store Procedure Update Sách
 CREATE PROC SP_UPDATEBOOK
 @MASACH INT,@TENSACH NVARCHAR (100), @NHAXUATBAN NVARCHAR(100), @NAMXUATBAN INT, @TOMTAT NVARCHAR(200), @GIABAN MONEY, @GIANHAP MONEY, @TONGSACHTON INT, @MATHELOAI INT
 AS
 BEGIN
	UPDATE SACH
	SET TENSACH=@TENSACH, NHAXUATBAN=@NHAXUATBAN,NAMXUATBAN=@NAMXUATBAN,TOMTAT=@TOMTAT,GIABAN=@GIABAN,GIANHAP=@GIANHAP,TONGSACHTON=@TONGSACHTON,MATHELOAI=@MATHELOAI
	WHERE MASACH=@MASACH
 END
 GO
 --Store Procedure Delete Sách
 CREATE PROC SP_DELETEBOOK
 @MASACH INT
 AS
 BEGIN
	DELETE SACH
	WHERE MASACH=@MASACH
 END
 GO
 --Store Procedure Insert Loại sách
 ALTER PROC SP_INSERTBOOKCATEGOGY
 @TENTHELOAI NVARCHAR(100)
 AS 
 BEGIN
	DECLARE @MATHELOAI INT, @MATHELOAI_MAX INT, @I INT
	SET @I=1
	SELECT @MATHELOAI_MAX=MAX(MATHELOAI)
	FROM LOAISACH
	IF(@MATHELOAI_MAX IS NULL)
		BEGIN
			INSERT INTO LOAISACH VALUES(@I,@TENTHELOAI)
		END
	ELSE
		BEGIN
			WHILE(@I<=@MATHELOAI_MAX+1)
				BEGIN
					IF(SELECT COUNT(*)
						FROM LOAISACH
						WHERE MATHELOAI=@I)=0
						BEGIN
							INSERT INTO LOAISACH VALUES(@I,@TENTHELOAI)
							BREAK
						END
						SET @I=@I+1
				END
		END
 END
 GO
 exec SP_INSERTBOOKCATEGOGY N'Truyện'
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
--Store Procedure xóa thể loại sách
CREATE PROC SP_DELETEBOOKCATEGOGY
@MATHELOAI INT
AS
BEGIN
	DELETE LOAISACH
	WHERE MATHELOAI=@MATHELOAI
END
GO
SELECT * FROM KHUYENMAI
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
		INSERT INTO KHUYENMAI (MAKM,TENKM,MUCTIEN,NGAYBD,NGAYKT,HESOKM)
					VALUES (@MAKM,@TENKM,@MUCTIEN,@NGAYBD_,@NGAYKT_,@HESOKM)
	ELSE
		BEGIN
			WHILE(@I<=@MAKM_MAX+1)
				BEGIN
					IF(SELECT COUNT(*)
						FROM KHUYENMAI
						WHERE MAKM=@I)=0
						BEGIN
							SET @MAKM=@I
							INSERT INTO KHUYENMAI (MAKM,TENKM,MUCTIEN,NGAYBD,NGAYKT,HESOKM)
							VALUES (@MAKM,@TENKM,@MUCTIEN,@NGAYBD_,@NGAYKT_,@HESOKM)
							BREAK
						END
						SET @I=@I+1
				END
	END
END
GO
EXEC SP_INSERTDISCOUNT N'Khuyến mãi cuối năm',0.05,'20000', '30-10-2018' , '30-11-2018'
GO
SELECT * FROM KHUYENMAI
GO
DELETE KHUYENMAI WHERE MAKM=2
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

SELECT * FROM KHACHHANG WHERE [dbo].[GetUnsignString](TENKH) LIKE N'%' + [dbo].[GetUnsignString](N'Thai') + '%'
go
--Store Tìm kiếm khách hàng theo tên
CREATE PROC SP_SEARCHCUSTOMER
@KEY NVARCHAR(100)
AS
BEGIN
	SELECT * FROM KHACHHANG WHERE [dbo].[GetUnsignString](TENKH) LIKE N'%' + [dbo].[GetUnsignString](@KEY) + '%'
END

GO
EXEC SP_SEARCHCUSTOMER N'Thai'
GO
EXEC SP_SEARCHCUSTOMER 'NGA'

-- Store proc Xuất danh sách tất cả khách hàng
 alter PROC SP_LOADCUSTOMER
 AS
 BEGIN
	SELECT MAKH, TENKH , DIACHI, SODT, NGAYSINH, NGAYDKY, DOANHSO
	FROM KHACHHANG
	ORDER BY MAKH DESC
 END
 GO
  EXEC SP_LOADCUSTOMER
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
		INSERT INTO KHACHHANG VALUES(1, @TENKH, @DIACHI, @SODT, @NGAYSINH_, @NGAYDKY_, NULL)
	END

	ELSE
	BEGIN
		WHILE(@I <= @MAKH_MAX + 1)
		BEGIN
			IF((SELECT COUNT(*) FROM KHACHHANG WHERE MAKH = @I) = 0)
			BEGIN
				INSERT INTO KHACHHANG VALUES(@I, @TENKH, @DIACHI, @SODT, @NGAYSINH_, @NGAYDKY_, NULL)
				BREAK
			END
			SET @I += 1
		END
	END
END

GO
EXEC SP_INSERTCUSTOMER N'Trương Quốc Thái', N'Quận Tân Bình, TPHCM', N'0874512349','17-2-1999', '27-10-2018'
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

EXEC SP_UPDATECUSTOMER 1, N'Nguyễn Thị Lan', N'Quận 1, TP.HCM', N'0978123450', '2-8-1990', '8-12-2018'
GO
--STORE PROC TÌM SÁCH
CREATE PROC SP_SEARCHBOOK
@KEY NVARCHAR(100)
AS
BEGIN
	
	SELECT MASACH, TENTHELOAI,TENSACH, NHAXUATBAN, NAMXUATBAN, TOMTAT, GIABAN, GIANHAP, TONGSACHTON
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
GO
SELECT * FROM CONGTY
GO
--STORE PROC LOAD CÔNG TY
CREATE PROC SP_LOAD_DISTRIBUTOR
AS
BEGIN
	SELECT * FROM CONGTY
END
GO
EXEC SP_LOAD_DISTRIBUTOR
GO
--STORE PROC INSERT CÔNG TY

ALTER PROC SP_INSERTDISTRIBUTOR
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
EXEC SP_INSERTDISTRIBUTOR N'A',N'A','190085123'
GO
SELECT * FROM CONGTY
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
--STORE PROC DELETE CONGTY
CREATE PROC SP_DELETEDISTRIBUTOR
@MACTY INT
AS
BEGIN
	DELETE FROM CONGTY 
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
EXEC SP_SEARCHDISTRIBUTOR 'CÔNG TY'
GO 
SELECT * FROM CT_PHIEUNHAP
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
EXEC SP_LOADBOOKSTOCK
GO
--STORE PROC LẤY DANH SÁCH CHI TIẾT PHIẾU NHẬP
CREATE PROC SP_LOADBOOKSTOCKDETAIL
AS
BEGIN
	SELECT SOPHIEUNHAP, TENSACH , SOLUONGNHAP, THANHTIEN
	FROM CT_PHIEUNHAP,SACH
	WHERE CT_PHIEUNHAP.MASACH=SACH.MASACH
END
GO
EXEC SP_LOADBOOKSTOCKDETAIL
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
		INSERT INTO PHIEUNHAP VALUES(@I,@NGAYNHAP_,@MACTY,0)
	ELSE
		BEGIN
			WHILE(@I<=@SOPHIEUNHAP_MAX+1)
				BEGIN
					IF(SELECT COUNT(*)
						FROM PHIEUNHAP
						WHERE SOPHIEUNHAP=@I)=0
						BEGIN
							SET @SOPHIEUNHAP=@I
							INSERT INTO PHIEUNHAP VALUES(@SOPHIEUNHAP,@NGAYNHAP_,@MACTY,0)
							BREAK
						END
					 SET @I=@I+1
				END
		END
END
GO
EXEC SP_INSERTBOOKSTOCK '1/11/2018',1
GO


SELECT * FROM PHIEUNHAP
--STORE PROC CẬP NHẬT PHIẾU NHẬP SÁCH
GO
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
ALTER PROC SP_DELETEBOOKSTOCK
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
EXEC SP_LOADBOOKSTOCK
GO
--STORE PROC THÊM CHI TIẾT PHIẾU NHẬP SÁCH
CREATE PROC SP_INSERTBOOKSTOCKDETAIL
@SOPHIEUNHAP INT,@MASACH INT, @SOLUONGNHAP INT
AS
BEGIN
	DECLARE @THANHTIEN FLOAT ,@GIANHAP FLOAT
	SELECT @GIANHAP=GIANHAP
	FROM SACH
	WHERE MASACH=@MASACH
	SET @THANHTIEN=@SOLUONGNHAP*@GIANHAP
	INSERT INTO CT_PHIEUNHAP VALUES(@SOPHIEUNHAP,@MASACH,@SOLUONGNHAP,@THANHTIEN)
END
GO
EXEC SP_INSERTBOOKSTOCKDETAIL 1,1,10
GO
SELECT * FROM CT_PHIEUNHAP
GO
--STRORE PROC SỬA CHI TIẾT PHIẾU NHẬP SÁCH
CREATE PROC SP_UPDATEBOOKSTOCKDETAIL
@SOPHIEUNHAP INT, @MASACH INT, @SOLUONGNHAP INT
AS
BEGIN
	
	UPDATE CT_PHIEUNHAP
	SET SOLUONGNHAP=@SOLUONGNHAP
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
	SELECT SOPHIEUNHAP, TENSACH , SOLUONGNHAP, THANHTIEN
	FROM CT_PHIEUNHAP,SACH
	WHERE CT_PHIEUNHAP.MASACH=SACH.MASACH AND SOPHIEUNHAP=@SOPHIEUNHAP
END
GO
<<<<<<< HEAD
--TRIGGER TÍNH THÀNH TIÊN CỦA BẢNG CHI TIẾT PHIẾU NHẬP SÁCH, TÍNH TỔNG TIỀN CỦA BẢNG PHIẾU NHẬP
CREATE TRIGGER TRG_INS_UP_CT_PHIEUNHAP ON CT_PHIEUNHAP
=======
--TRIGGER TÍNH THÀNH TIÊN CỦA BẢNG CHI TIẾT PHIẾU NHẬP SÁCH, TÍNH TỔNG TIỀN CỦA BẢNG PHIẾU NHẬP, CẬP NHẬT SỐ LƯỢNG SÁCH TỒN TRONG BẢNG SÁCH
ALTER TRIGGER TRG_INS_UP_CT_PHIEUNHAP ON CT_PHIEUNHAP
>>>>>>> a415825debae1f4ddcce64b1dd8991673fed3400
FOR INSERT,UPDATE
AS
BEGIN
	DECLARE @SOPHIEUNHAP INT, @MASACH INT, @SOLUONGNHAP INT, @THANHTIEN MONEY,@THANHTIEN_ MONEY, @GIANHAP MONEY,@TONGTIEN MONEY,@TONGSACHTON INT
	SELECT @SOPHIEUNHAP=SOPHIEUNHAP,@MASACH=MASACH,@SOLUONGNHAP=SOLUONGNHAP,@THANHTIEN=THANHTIEN
	FROM inserted
	SELECT @GIANHAP=GIANHAP
	FROM SACH 
	WHERE MASACH=@MASACH
	SET @THANHTIEN_=@SOLUONGNHAP*@GIANHAP
	--CẬP NHẬT LẠI THANHTIEN Ở BẢNG CT_PHIEUNHAP
	UPDATE CT_PHIEUNHAP
	SET THANHTIEN=@THANHTIEN_
	WHERE MASACH=@MASACH
	--CẬP NHẬT LẠI TONGTIEN Ở PHIẾU NHẬP
	SELECT @TONGTIEN=(SELECT SUM(THANHTIEN)
					  FROM CT_PHIEUNHAP
					  WHERE SOPHIEUNHAP=@SOPHIEUNHAP
					  GROUP BY(SOPHIEUNHAP))
	UPDATE PHIEUNHAP
	SET TONGTIEN=@TONGTIEN
	WHERE SOPHIEUNHAP=@SOPHIEUNHAP
	--CẬP NHẬT LẠI TONGSOLUONGTON Ở BẢNG SÁCH
	SELECT @TONGSACHTON=TONGSACHTON
	FROM SACH
	WHERE MASACH=@MASACH
	UPDATE SACH
	SET TONGSACHTON=@TONGSACHTON+@SOLUONGNHAP
	WHERE MASACH=@MASACH
END
GO
SELECT * FROM SACH
GO
--TRIGGER KHI XÓA CHI TIẾT PHIẾU NHẬP SÁCH
CREATE TRIGGER TRG_DEL_CT_PHIEUNHAP ON CT_PHIEUNHAP
FOR DELETE
AS
BEGIN
	DECLARE @SOPHIEUNHAP INT,@MASACH INT,@SOLUONGNHAP INT
	SELECT @SOPHIEUNHAP=SOPHIEUNHAP,@MASACH=MASACH,@SOLUONGNHAP=SOLUONGNHAP
	FROM deleted
	DECLARE @TONGTIEN MONEY
	SET @TONGTIEN=(SELECT SUM(THANHTIEN)
					FROM CT_PHIEUNHAP
					WHERE SOPHIEUNHAP=@SOPHIEUNHAP)
	--CẬP NHẬT TONGTIEN Ở SỐ PHIẾU NHẬP
	UPDATE PHIEUNHAP
	SET TONGTIEN=@TONGTIEN
	WHERE SOPHIEUNHAP=@SOPHIEUNHAP
	DECLARE @TONGSACHTON INT
	SELECT @TONGSACHTON=TONGSACHTON
	FROM SACH
	WHERE MASACH=@MASACH
	UPDATE SACH
	SET TONGSACHTON=@TONGSACHTON-@SOLUONGNHAP
	WHERE MASACH=@MASACH
END
GO
EXEC SP_LOADBOOKSTOCKDETAIL
<<<<<<< HEAD
--Lấy thông tin hóa đơn
GO
CREATE PROC SP_LOADBILL
AS
BEGIN
	SELECT * FROM HOADON
END
GO
-- Thêm hóa đơn
GO
ALTER PROC SP_INSERTBILL
@NGAYHD VARCHAR(19), @MAKH INT, @MANV INT, @VAT FLOAT
AS
BEGIN
	DECLARE @SOHD_MAX INT, @I INT, @NGAYHD_ SMALLDATETIME

	SELECT @SOHD_MAX = MAX(SOHD)
	FROM HOADON

	SET @I = 1
	SET @NGAYHD_ = CONVERT(SMALLDATETIME, @NGAYHD, 103)

	IF(@MAKH = 0)
		SET @MAKH = NULL
	
	IF(@SOHD_MAX IS NULL)
	BEGIN
		INSERT INTO HOADON VALUES(1, @NGAYHD_, @MAKH, @MANV, @VAT, NULL, NULL)
	END
	ELSE
	BEGIN
		WHILE(@I <= @SOHD_MAX + 1)
		BEGIN
			IF((SELECT COUNT(*) FROM HOADON WHERE SOHD = @I) < 1)
			BEGIN
				INSERT INTO HOADON VALUES(@I, @NGAYHD_, @MAKH, @MANV, @VAT, NULL, NULL)
				BREAK
			END
			SET @I += 1
		END
	END	
END
GO

EXEC SP_INSERTBILL '8-11-2018', 0, 1, 0.2
SELECT * FROM HOADON

select * from HOADON
-- Cập nhật hóa đơn
ALTER PROC SP_UPDATEBILL
@SOHD INT, @NGAYHD VARCHAR(19), @MAKH INT, @MANV INT, @VAT FLOAT
AS
BEGIN
	DECLARE @NGAYHD_ SMALLDATETIME

	SET @NGAYHD_ = CONVERT(SMALLDATETIME, @NGAYHD, 103)

	IF(@MAKH = 0)
		SET @MAKH = NULL

	UPDATE HOADON
	SET NGAYHD = @NGAYHD_, MAKH = @MAKH, VAT = @VAT
	WHERE SOHD = @SOHD
END
GO

-- Xóa hóa đơn
CREATE PROC SP_DELETEBILL
@SOHD INT
AS
BEGIN
	DELETE FROM HOADON
	WHERE SOHD = @SOHD
END
-- Tìm hóa đơn theo ngày
ALTER PROC SP_SEARCHBILL
@NGAYHD VARCHAR(19)
AS
BEGIN
	DECLARE @NGAYHD_ SMALLDATETIME

	SET @NGAYHD_ = CONVERT(SMALLDATETIME, @NGAYHD, 103)

	IF(@NGAYHD = '')
		SELECT * FROM HOADON
	ELSE
		SELECT * FROM HOADON WHERE NGAYHD = @NGAYHD_
END

--TRIGER TÍNH THANHTIEN TRONG CTHD
GO
CREATE TRIGGER TRG_INSUP_THANHTIEN_CTTT ON CTHD
FOR INSERT, UPDATE
AS
BEGIN
	DECLARE @SOHD INT, @MASACH INT, @SOLUONG INT

	SELECT @SOHD = SOHD, @MASACH = MASACH, @SOLUONG = SOLUONG
	FROM inserted

	UPDATE CTHD
	SET THANHTIEN = (SELECT GIABAN FROM SACH WHERE MASACH = @MASACH) * @SOLUONG
	WHERE SOHD = @SOHD
END

--TRIGGER CẬP NHẬT TRIGIA, TONGTIEN HÓA ĐƠN KHI THÊM, CẬP NHẬT, XÓA 1 CTHD
GO
CREATE TRIGGER TRG_INS_CTHD ON CTHD
FOR INSERT
AS
BEGIN
	DECLARE @SOHD INT, @MASACH INT, @SOLUONG INT, 
END
=======
GO
SELECT * FROM HOADON
>>>>>>> a415825debae1f4ddcce64b1dd8991673fed3400

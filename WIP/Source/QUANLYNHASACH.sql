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
 CREATE PROC SP_INSERTBOOKCATEGOGY
 @TENTHELOAI NVARCHAR(100)
 AS 
 BEGIN
	DECLARE @MATHELOAI INT, @MATHELOAI_MAX INT, @I INT
	SET @I=1
	SELECT @MATHELOAI_MAX=MAX(MATHELOAI)
	FROM LOAISACH
	WHILE(@I<=@MATHELOAI_MAX)
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
	IF(@I>@MATHELOAI_MAX)
		BEGIN
			SET @MATHELOAI=@MATHELOAI_MAX+1
			INSERT INTO LOAISACH VALUES(@MATHELOAI,@TENTHELOAI)
		END
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
ALTER PROC SP_INSERTDISCOUNT
@TENKM NVARCHAR(100), @HESOKM FLOAT, @MUCTIEN MONEY, @NGAYBD VARCHAR(19), @NGAYKT VARCHAR(19)
AS
BEGIN
	--SELECT convert(varchar,getdate(),5) 
	DECLARE @NGAYBD_ SMALLDATETIME, @NGAYKT_ SMALLDATETIME
	--SET @NGAYBD_=CONVERT(smalldatetime, left(@NGAYBD, 19), 120);
	--SET @NGAYKT_=CONVERT(smalldatetime, left(@NGAYKT, 19), 120);
	--SET @NGAYBD_=(CAST(@NGAYBD AS smalldatetime))
	--SET @NGAYKT_=(CAST(@NGAYKT AS smalldatetime))
	SET @NGAYBD_=CONVERT(smalldatetime,@NGAYBD,103)
	SET @NGAYKT_=CONVERT(smalldatetime,@NGAYKT,103)
	DECLARE @MAKM INT, @MAKM_MAX INT, @I INT
	SET @I=1
	SELECT @MAKM_MAX=MAX(MAKM)
	FROM KHUYENMAI
	WHILE(@I<=@MAKM_MAX)
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
	IF(@I>@MAKM_MAX)
		BEGIN
			SET @MAKM=@MAKM_MAX+1
			INSERT INTO KHUYENMAI (MAKM,TENKM,MUCTIEN,NGAYBD,NGAYKT,HESOKM)
			VALUES (@MAKM,@TENKM,@MUCTIEN,@NGAYBD_,@NGAYKT_,@HESOKM)
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
ALTER PROC SP_UPDATEDISCOUNT
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

SELECT * FROM KHACHHANG WHERE [dbo].[GetUnsignString](TENKH) LIKE N'%' + [dbo].[GetUnsignString](N'o') + '%'

--Store Tìm kiếm khách hàng theo tên
alter PROC SP_SEARCHCUSTOMER
@KEY NVARCHAR
AS
BEGIN
	SELECT * FROM KHACHHANG WHERE [dbo].[GetUnsignString](TENKH) LIKE N'%' + [dbo].[GetUnsignString](@KEY) + '%'
END
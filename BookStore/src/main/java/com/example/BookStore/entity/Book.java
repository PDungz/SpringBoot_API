package com.example.BookStore.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotBlank(message = "Tiêu đề không được để trống")
	@Size(max=50, message = "Độ dài tiêu đề không vượt quá 50 ký tự")
	@Column(name = "title", length = 50)
	private String title;
	
	@NotBlank(message = "Tác giả không được để trống")
	@Size(max=50, message = "Độ dài tiêu đề không vượt quá 50 ký tự")
	@Pattern(regexp = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯăêôơÁẮẤÉẾÍÓỐÔÚỨỳỵỷỹÝỲ\\s]+$",
	message = "Tên tác giả không được chứa số hoặc ký tự đặc biệt")
	@Column(name = "author", length = 50)
	private String author;
	
	@NotNull(message = "Ngày nhập không được để trống")
	@Past(message = "Ngày nhập phải nhỏ hơn ngày hiện tại")
	@Column(name = "publishedDate", length = 50)
	private LocalDate publishedDate;
	
	@NotNull(message = "Giá không được để trống")
	@DecimalMin(value = "0.0", inclusive = true, message = "Giá tiền phải lớn hơn hoặc bằng 0")
	@Column(name = "price", nullable = false)
	private Double price;
	
	@NotNull(message = "Số lượng không được để trống")
	@Min(value = 1, message = "Số lượng phải lớn hơn 0")
	@Column(name = "quantity", nullable = false)
	private int quantity;
}

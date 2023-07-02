df_mileage_group = sqlc.createDataFrame([
    Row(group="Overall Corr Mileage, price", corr=df_milage.stat.corr("mileage", "price")),
    Row(group="Sedan", corr=df_milage.where(col("body_type") == "Sedan").stat.corr("mileage", "price")),
    Row(group="Size low", corr=df_milage.where(col("size") == "low").stat.corr("mileage", "price")),
    Row(group="Size medium", corr=df_milage.where(col("size") == "medium").stat.corr("mileage", "price")),
    Row(group="Size high", corr=df_milage.where(col("size") == "high").stat.corr("mileage", "price")),
    Row(group="Size low, horsepower low", corr=df_milage.where((col("size") == "low") & (col("horsepower_cat") == "low")).stat.corr("mileage", "price")),
    Row(group="Size low, horsepower medium", corr=df_milage.where((col("size") == "low") & (col("horsepower_cat") == "medium")).stat.corr("mileage", "price")),
    Row(group="Size low, horsepower high", corr=df_milage.where((col("size") == "low") & (col("horsepower_cat") == "high")).stat.corr("mileage", "price"))
], schema='group String, corr double')


# does the price vary by city?
print("Overall mean price") 
df_city.groupBy("city").mean("price").show()

# per group?
print("Sedan")
df_city.where(col("body_type") == "Sedan").groupBy("city").mean("price").show()
print("size low")
df_city.where(col("size") == "low").groupBy("city").mean("price").show()
print("size medium")
df_city.where(col("size") == "medium").groupBy("city").mean("price").show()
print("size high")
df_city.where(col("size") == "high").groupBy("city").mean("price").show()
print("Size low, horsepower low")
df_city.where((col("size") == "low") & (col("horsepower_cat") == "low")).groupBy("city").mean("price").show()
print("Size low, horsepower medium")
df_city.where((col("size") == "low") & (col("horsepower_cat") == "medium")).groupBy("city").mean("price").show()
print("Size low, horsepower high")
df_city.where((col("size") == "low") & (col("horsepower_cat") == "high")).groupBy("city").mean("price").show()



# does the listing price change over time
print("Overall")
df_time.groupBy(year("listed_date").alias("Year"), month("listed_date").alias("Month")).mean("price").sort(col("Year"), col("Month")).show()
print("Small Cars")
df_time.where(col("size") == "low").groupBy(year("listed_date").alias("Year"), month("listed_date").alias("Month")).mean("price").sort(col("Year"), col("Month")).show()
print("Medium Cars")
df_time.where(col("size") == "medium").groupBy(year("listed_date").alias("Year"), month("listed_date").alias("Month")).mean("price").sort(col("Year"), col("Month")).show()
print("Big Cars")
df_time.where(col("size") == "high").groupBy(year("listed_date").alias("Year"), month("listed_date").alias("Month")).mean("price").sort(col("Year"), col("Month")).show()


print("Overall")
df_color.groupBy("interior_color").mean("price").sort(col("avg(price)").desc()).show()
print("Small Cars")
df_color.where(col("size") == "low").groupBy("interior_color").mean("price").sort(col("avg(price)").desc()).show()
print("Medium Cars")
df_color.where(col("size") == "medium").groupBy("interior_color").mean("price").sort(col("avg(price)").desc()).show()
print("Big Cars")
df_color.where(col("size") == "low").groupBy("interior_color").mean("price").sort(col("avg(price)").desc()).show()

print("Overall")
df_color.groupBy("exterior_color").mean("price").sort(col("avg(price)").desc()).show()
print("Small Cars")
df_color.where(col("size") == "low").groupBy("exterior_color").mean("price").sort(col("avg(price)").desc()).show()
print("Medium Cars")
df_color.where(col("size") == "medium").groupBy("exterior_color").mean("price").sort(col("avg(price)").desc()).show()
print("Big Cars")
df_color.where(col("size") == "low").groupBy("exterior_color").mean("price").sort(col("avg(price)").desc()).show()

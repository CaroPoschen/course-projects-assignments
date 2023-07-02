# visulaize data in Databricks

df_time_disp = df_time.groupBy(year("listed_date").alias("Year"), month("listed_date").alias("Month")).mean("price").sort(col("Year"), col("Month"))
display(df_time_disp)

df_city_disp = df_city.groupBy("city").mean("price").limit(10)
display(df_city_disp)

df_color_disp = df_color.groupBy("interior_color").mean("price").limit(10)
display(df_color_disp)

df_color_disp = df_color.groupBy("exterior_color").mean("price").limit(10)
display(df_color_disp)

df_af_disp = df_accident_fleet.groupBy(col("has_accidents"), col("fleet")).mean("price")
display(df_af_disp)


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator {

    public static void main(String[] args) {
        // 数据源配置
        String jdbcUrl = "jdbc:mysql://localhost:3306/cloud_center?useUnicode=true&useSSL=false&characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        DataSourceConfig.Builder builder = new DataSourceConfig.Builder(jdbcUrl, username, password);
        DataSourceConfig dataSourceConfig = builder.build();

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator(dataSourceConfig);

        // 全局配置
        GlobalConfig.Builder globalConfigBuilder = new GlobalConfig.Builder();
        String projectPath = System.getProperty("user.dir");
        globalConfigBuilder
                // .outputDir("/src/main/java")
                .outputDir("/Users/chensicong/IdeaProjects/mybatis-plus-lab/old-version-generator/src/main/java")
                .author("chensicong")
                .openDir(false)
                .enableSwagger(); // 实体属性 Swagger2 注解

        GlobalConfig globalConfig = globalConfigBuilder.build();

        // 包配置
        String parentPackage = "com.chensc.autogenerator";
        // 模块名
        String parentModule = "lab";

        PackageConfig pc = new PackageConfig.Builder(parentPackage, parentModule)
                .build();


        // 策略配置
        StrategyConfig strategy = new StrategyConfig.Builder()
                .addTablePrefix("t_")
                .entityBuilder()
                .columnNaming(NamingStrategy.underline_to_camel)
                .naming(NamingStrategy.underline_to_camel)
                .idType(IdType.ASSIGN_ID)
                // .superClass()
                .enableLombok()
                .build();

        mpg.global(globalConfig);
        mpg.packageInfo(pc);
        mpg.strategy(strategy);
        mpg.execute();

    }

}

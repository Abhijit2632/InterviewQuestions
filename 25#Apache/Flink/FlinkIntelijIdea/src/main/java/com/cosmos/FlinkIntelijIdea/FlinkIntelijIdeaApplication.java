package com.cosmos.FlinkIntelijIdea;

import ch.qos.logback.core.subst.Tokenizer;
import com.cosmos.FlinkIntelijIdea.first.CountOcuranceInFile;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.core.fs.FileSystem;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Slf4j
public class FlinkIntelijIdeaApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(FlinkIntelijIdeaApplication.class, args);

		//1. Set up env for the program using -- ExecutionEnvironment which is responsible to chose correct env i.e. local/remote accordingly
		final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
		//for stream execution env will be,
		//final StreamExecutionEnvironment env2 = StreamExecutionEnvironment.getExecutionEnvironment();
		//2.ParameterTool will help in reading parameters from configuration files
		final ParameterTool params = ParameterTool.fromArgs(args);
		//log.info("Contents of args-------------- "+args[0]);
		//3.
		env.getConfig().setGlobalJobParameters(params);
		env.setParallelism(1);
		/*String path = "";
		if (args.length == 1 && args[0] != null) {
			path = params.getRequired("filename");
			log.info("Contents of path-------------- "+path);
		}else{
			path = "file:///Users/abhijit4981/Desktop/InterviewDocs/Apache/Flink/names.txt";
			log.info("Contents of path hardcoded-------------- "+path);
		}*/
		DataSet<String> text = env.readTextFile(params.get("filename"));

		//Ur Code Starts here

		DataSet<Tuple2<String,Integer>> counts = CountOcuranceInFile.getCounts(text);



















		//Ur Code Ends here

		counts.writeAsCsv(params.get("output"),"\n",",", FileSystem.WriteMode.OVERWRITE);
				// "\n", FileSystem.WriteMode.OVERWRITE,"");
		/*DataSet<Integer> amounts = (DataSet<Integer>) env.fromElements(1, 29, 40, 50);

		int threshold = 30;
		try {
			List<Integer> collect = amounts
					.filter(a -> a > threshold)
					.reduce((integer, t1) -> integer + t1)
					.collect();
			log.info("Got this data-------------- "+collect);
		} catch (Exception e) {
			log.info(e.getMessage());
		}*/
		//4.Trigers the execution of program so is the must
		env.execute();
	}
}
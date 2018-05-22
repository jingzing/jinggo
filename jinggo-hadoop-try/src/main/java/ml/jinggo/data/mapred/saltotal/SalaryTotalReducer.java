package ml.jinggo.data.mapred.saltotal;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author wangyj
 * @description
 * @create 2018-05-22 18:21
 **/
//                                                k3      v3     k4      v4
public class SalaryTotalReducer extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {

    @Override
    protected void reduce(IntWritable k3, Iterable<IntWritable> v3,Context context)
            throws IOException, InterruptedException {
        //对v3求和，得到该部门的工资总额
        int total = 0;
        for(IntWritable v:v3){
            total += v.get();
        }

        //输出                    部门号   总额
        context.write(k3, new IntWritable(total));
    }

}

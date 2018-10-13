package parse.json.com.jsonparse;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder>{

    public Employee[] mEmployees;

    public EmployeeAdapter(Employees[] emps){
        mEmployees = emps;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View empView = inflater.inflate(R.layout.employee_layout, parent, false);
        RecyclerView.ViewHolder viewHolder = new ViewHolder(empView);
        return (ViewHolder) viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employee employee = mEmployees[position];
        TextView nameTextView = holder.employeeNameTextView;
        nameTextView.setText(employee.getName().toString());

        TextView ageTextView = holder.employeeAgeTextView;
        ageTextView.setText(String.valueOf(employee.getAge()));

        TextView companyTextView = holder.employeeComplaniesTextView;
//        Arrays companyArray;
//        for (Company company : employee.getComplanies()){
//            companyArray.add(company.getName());
//        }
//        companyTextView.setText(companyArray.toString());

        TextView locationTextView = holder.employeeLocationTextView;
        locationTextView.setText(employee.getLocation());
    }

    @Override
    public int getItemCount() {
        return mEmployees.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView employeeNameTextView;
        public TextView employeeComplaniesTextView;
        public TextView employeeLocationTextView;
        public TextView employeeAgeTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            employeeNameTextView = itemView.findViewById(R.id.employeeNameTextView);
            employeeComplaniesTextView = itemView.findViewById(R.id.employeeComplaniesTextView);
            employeeLocationTextView = itemView.findViewById(R.id.employeeLocationTextView);
            employeeAgeTextView = itemView.findViewById(R.id.employeeAgeTextView);

        }
    }
}

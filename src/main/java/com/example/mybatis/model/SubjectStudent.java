package com.example.mybatis.model;

public class SubjectStudent {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SUBJECT_STUDENT.SUBJECT_ID
     *
     * @mbg.generated Tue May 03 23:31:01 EEST 2022
     */
    private Integer subjectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SUBJECT_STUDENT.STUDENTS_ID
     *
     * @mbg.generated Tue May 03 23:31:01 EEST 2022
     */
    private Integer studentsId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SUBJECT_STUDENT.SUBJECT_ID
     *
     * @return the value of PUBLIC.SUBJECT_STUDENT.SUBJECT_ID
     *
     * @mbg.generated Tue May 03 23:31:01 EEST 2022
     */
    public Integer getSubjectId() {
        return subjectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SUBJECT_STUDENT.SUBJECT_ID
     *
     * @param subjectId the value for PUBLIC.SUBJECT_STUDENT.SUBJECT_ID
     *
     * @mbg.generated Tue May 03 23:31:01 EEST 2022
     */
    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SUBJECT_STUDENT.STUDENTS_ID
     *
     * @return the value of PUBLIC.SUBJECT_STUDENT.STUDENTS_ID
     *
     * @mbg.generated Tue May 03 23:31:01 EEST 2022
     */
    public Integer getStudentsId() {
        return studentsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SUBJECT_STUDENT.STUDENTS_ID
     *
     * @param studentsId the value for PUBLIC.SUBJECT_STUDENT.STUDENTS_ID
     *
     * @mbg.generated Tue May 03 23:31:01 EEST 2022
     */
    public void setStudentsId(Integer studentsId) {
        this.studentsId = studentsId;
    }
}
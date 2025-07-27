import styles from './CohortDetails.module.css';

function CohortDetails(props) {
    // Define the conditional style object for the h3 element.
    // It sets the color to green if the status is 'Ongoing', otherwise it's blue.
    const headerStyle = {
        color: props.cohort.currentStatus === 'Ongoing' ? 'green' : 'blue'
    };

    return (
        // 1. Applied the 'box' class from the imported CSS module.
        <div className={styles.box}>
            {/* 2. Applied the conditional inline style to the h3 tag. */}
            <h3 style={headerStyle}>
                {props.cohort.cohortCode} -
                <span>{props.cohort.technology}</span>
            </h3>
            <dl>
                <dt>Started On</dt>
                <dd>{props.cohort.startDate}</dd>
                <dt>Current Status</dt>
                <dd>{props.cohort.currentStatus}</dd>
                <dt>Coach</dt>
                <dd>{props.cohort.coachName}</dd>
                <dt>Trainer</dt>
                <dd>{props.cohort.trainerName}</dd>
            </dl>
        </div>
    );
}

export default CohortDetails;